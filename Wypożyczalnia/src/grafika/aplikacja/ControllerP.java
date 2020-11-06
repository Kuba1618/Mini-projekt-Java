package grafika.aplikacja;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;

public class ControllerP {

    ObservableList<String> marka = FXCollections.observableArrayList("Fiat","Opel","Skoda","Toyota","VolksWagen");
    ObservableList<String> model = FXCollections.observableArrayList("Tipo","Astra H","Octavia","Yaris","Golf IV");
    ObservableList<String> rejestracja = FXCollections.observableArrayList("TKI 12345","TK 84GF");
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
    private TextField carBrandField1,modelField1,registrationNumberField1,yearField1,idendityField2;
    @FXML
    private TextField nameFieldZ1,lastNameFieldZ1,phoneFieldZ1;
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
    private void saveCar(){
        String marka = String.valueOf(carBrandField1.getCharacters());
        String model = String.valueOf(modelField1.getCharacters());
        String nrRejestracyjny = String.valueOf(registrationNumberField1.getCharacters());
        int rocznik = Integer.parseInt(String.valueOf(yearField1.getCharacters()));
        String fuel = String.valueOf(fuelChoise1.getValue());
        boolean hak = haveHookBox1.isSelected();

        System.out.print("Marka:" + marka + "  Model:" + model + "  NrRejestracyjny:" + nrRejestracyjny
                + "  Rocznik: " + rocznik + "  Paliwo:" +  fuel);
        if (hak == true) {
            System.out.println(" (Samochód ma haka)");
        } else {
            System.out.println(" (Samochód nie ma haka)");
        }
    }

    @FXML
    private void hireCar(){
        String marka = String.valueOf(brandCarChoise2.getValue());
        String model = String.valueOf(modelCarChoise2.getValue());
        Date dataWypozyczenia = Date.valueOf(borrowDatePicker2.getValue());
        Date dataOddania = Date.valueOf(backDatePicker2.getValue());
        int idWypozyczajacego = Integer.parseInt(String.valueOf(idendityField2.getCharacters()));

        System.out.println("Marka:" + marka + "  Model:" + model + "  Data Wypożyczenia:" + dataWypozyczenia +
                "  Data oddania:" + dataOddania + "  Id wypozyczającego:" + idWypozyczajacego);
    }

    @FXML
    private void createAccount(){
        String imie = String.valueOf(nameFieldZ1.getCharacters());
        String nazwisko =  String.valueOf(lastNameFieldZ1.getCharacters());
        int nrTel = Integer.parseInt(String.valueOf(phoneFieldZ1.getCharacters()));
        Date dataUro = Date.valueOf(dateOfBirthCalendarZ1.getValue());
        boolean kobieta = womanRadioButtonZ1.isSelected(),facet = manRadioButtonZ1.isSelected();
        if(acceptBoxZ1.isSelected())
        {
            System.out.println("Zarejestrowano:");
            System.out.print("  Imie:" + imie + "  Nazwisko:" + nazwisko + "  Telefon:" + nrTel + "  Data urodzin:" + dataUro);

            System.out.print("  Płeć:");
            if(kobieta && facet == false){
                System.out.println(womanRadioButtonZ1.getText());
            }
            else if(facet && kobieta == false){
                System.out.println(manRadioButtonZ1.getText());
            }
            else if(kobieta && facet) {
                manRadioButtonZ1.fire();
                System.out.println(womanRadioButtonZ1.getText());
            }
            else
            {
                manRadioButtonZ1.fire();
                System.out.println(manRadioButtonZ1.getText());
            }
        }
        else
        {
            System.out.println("Akceptacja regulaminu jest obowiązkowa!");
        }

    }

    @FXML
    private void checkOffer(){
        String marka = String.valueOf(brandCarChoiseZ2.getValue());
        String model = String.valueOf(modelCarChoiseZ2.getValue());
        int iloscDob = Integer.parseInt(String.valueOf(howDaysChoiseZ2.getValue()));
        boolean fotelik = fotelikBoxZ2.isSelected();
        boolean narty = bagaznikNartyBoxZ2.isSelected();
        boolean ubezpieczenie = extraInsuaranceBoxZ2.isSelected();

        System.out.print("Marka:" + marka + "  Model:" + model + "  Ilosc dni:" + iloscDob);
        System.out.print("  Dodatkowe:");
        if(fotelik || narty || ubezpieczenie) {
            if(fotelik) System.out.print("fotelik,");
            if(narty) System.out.print("bagaznik na narty,");
            if(ubezpieczenie) System.out.print("ubezpieczenie");
            System.out.println(" ");
        }
        else {
            System.out.println(" brak");
        }

    }



    /*public void wyswietlKomunikat(Event event) {
        System.out.println(event.getSource());
        System.out.println("Przycisk działa !");
    }*/
}
