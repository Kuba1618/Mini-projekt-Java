package grafika.aplikacja;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import logika.aplikacja.Auto;
import logika.aplikacja.Client;

import java.io.IOException;
import java.sql.Date;
import java.util.List;


public class ControllerP {

    ObservableList<String> marka = FXCollections.observableArrayList("Fiat","Opel","Skoda","Toyota","VolksWagen");
    ObservableList<String> model = FXCollections.observableArrayList("Tipo","Astra H","Octavia","Yaris","Golf IV");
    ObservableList<String> paliwo = FXCollections.observableArrayList("Benzyna","Diesel","Benzyna + LPG");
    ObservableList<String> dni = FXCollections.observableArrayList("10","20","30","50","100");

    //---------------ChoiceBox-----------------------
    @FXML
    private ChoiceBox fuelChoise1,howDaysChoiseZ2;
    @FXML
    private ChoiceBox brandCarChoise2,brandCarChoiseZ2;
    @FXML
    private ChoiceBox modelCarChoise2,modelCarChoiseZ2;
    //---------------TextField------------------------
    @FXML
    private TextField carBrandField1,modelField1,registrationNumberField1,yearField1;
    @FXML
    private TextField nameFieldZ1,lastNameFieldZ1,phoneFieldZ1,peselFieldZ11,peselNumberField2,nameFieldW2,lastNameFieldW2;
    //--------------DatePicker------------------
    @FXML
    private DatePicker borrowDatePicker2,backDatePicker2,dateOfBirthCalendarZ1;
    //--------------CheckBox--------------------
    @FXML
    private CheckBox haveHookBox1,acceptBoxZ1;
    @FXML
    private CheckBox fotelikBoxZ2,extraInsuaranceBoxZ2,bagaznikNartyBoxZ2;
    //--------------RadioButton------------------
    @FXML
    private RadioButton womanRadioButtonZ1,manRadioButtonZ1;


    @FXML
    private void initialize(){
        //wybór paliwa
        fuelChoise1.setValue("Benzyna");
        fuelChoise1.setItems(paliwo);
        //wybór marki
        brandCarChoise2.setValue("VolksWagen");
        brandCarChoise2.setItems(marka);
        brandCarChoiseZ2.setValue("VolksWagen");
        brandCarChoiseZ2.setItems(marka);
        //wybór modelu
        modelCarChoise2.setValue("Golf IV");
        modelCarChoise2.setItems(model);
        modelCarChoiseZ2.setValue("Golf IV");
        modelCarChoiseZ2.setItems(model);
        //na ile dni wypozyczyc auto
        howDaysChoiseZ2.setValue("30");
        howDaysChoiseZ2.setItems(dni);
    }

    @FXML
    private void createAccount() throws IOException {
        String imie = String.valueOf(nameFieldZ1.getCharacters());
        String nazwisko =  String.valueOf(lastNameFieldZ1.getCharacters());
        int nrTel = Integer.parseInt(String.valueOf(phoneFieldZ1.getCharacters()));
        Date dataUro = Date.valueOf(dateOfBirthCalendarZ1.getValue());
        long nrPesel = Long.valueOf(String.valueOf(peselFieldZ11.getCharacters()));
        boolean kobieta = womanRadioButtonZ1.isSelected(),facet = manRadioButtonZ1.isSelected();
        char plec = 'M';

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);

        if(acceptBoxZ1.isSelected())
        {
            alert.setContentText("Konto zostało utworzone!");

            if(kobieta && facet == false){
                plec = 'K';
            }
            else if(facet && kobieta == false){
                plec = 'M';
            }
            else if(kobieta && facet) {
                manRadioButtonZ1.fire();
                plec = 'K';
            }
            else
            {
                manRadioButtonZ1.fire();
                plec = 'M';
            }
        }
        else
        {
            alert.setContentText("Akceptacja regulaminu jest obowiązkowa!");;
        }

        alert.showAndWait();

        Client client = new Client("127.0.0.1", 5590);
        client.send(imie + " " + nazwisko + " " + nrTel + " " + dataUro + " " + nrPesel + " " + plec);

        List x = client.read();
        for(int i = 0; i < x.size(); i++) {
        System.out.println("server: " + x.get(i)); }
    }

    @FXML
    private void addCar() throws IOException {
        String marka = String.valueOf(carBrandField1.getCharacters());
        String model = String.valueOf(modelField1.getCharacters());
        String nrRejestracyjny = String.valueOf(registrationNumberField1.getCharacters());
        int rocznik = Integer.parseInt(String.valueOf(yearField1.getCharacters()));
        String fuel = String.valueOf(fuelChoise1.getValue());
        boolean hak = haveHookBox1.isSelected();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText(marka + " " + model + " " + nrRejestracyjny + " " + "został dodany");

        alert.showAndWait();

        Client client = new Client("127.0.0.1", 5590);
        client.send(marka + " " + model + " " + nrRejestracyjny + " " + "został dodany");

        List x = client.read();
        for(int i = 0; i < x.size(); i++) {
            System.out.println("server: " + x.get(i)); }
    }

    @FXML
    private void checkOffer() throws IOException {
        String marka = String.valueOf(brandCarChoiseZ2.getValue());
        String model = String.valueOf(modelCarChoiseZ2.getValue());
        int iloscDob = Integer.parseInt(String.valueOf(howDaysChoiseZ2.getValue()));
        boolean fotelik = fotelikBoxZ2.isSelected();
        boolean narty = bagaznikNartyBoxZ2.isSelected();
        boolean ubezpieczenie = extraInsuaranceBoxZ2.isSelected();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText(marka + " " + model + " na " + iloscDob + " dni " + "kosztuje: ");

        alert.showAndWait();

        Client client = new Client("127.0.0.1", 5590);
        client.send(marka + " " + model + " na " + iloscDob + " dni " + "kosztuje: ");

        List x = client.read();
        for(int i = 0; i < x.size(); i++) {
            System.out.println("server: " + x.get(i)); }
    }

    @FXML
    private void hireCar() throws IOException {
        String marka = String.valueOf(brandCarChoise2.getValue());
        String model = String.valueOf(modelCarChoise2.getValue());
        Date dataWypozyczenia = Date.valueOf(borrowDatePicker2.getValue());
        Date dataOddania = Date.valueOf(backDatePicker2.getValue());
        String imieWyp = String.valueOf(nameFieldW2.getCharacters());
        String nazwiskoWyp = String.valueOf(lastNameFieldW2.getCharacters());
        Long peselWyp = Long.valueOf(String.valueOf(peselNumberField2.getCharacters()));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText(marka + " " + model + " od dnia " + dataWypozyczenia + " do dnia " + dataOddania + " został wypożyczony!");

        alert.showAndWait();

        Client client = new Client("127.0.0.1", 5590);
        client.send(marka + " " + model + " od dnia " + dataWypozyczenia + " do dnia " + dataOddania + " został wypożyczony!");

        List x = client.read();
        for(int i = 0; i < x.size(); i++) {
            System.out.println("server: " + x.get(i)); }
    }

}
