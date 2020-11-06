package grafika.aplikacja;

import logika.aplikacja.Garaz;
import logika.aplikacja.KatalogWypozyczen;
import logika.aplikacja.Spolecznosc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;



public class ControllerP {

    Garaz garaz = new Garaz();
    Spolecznosc spolecznosc = new Spolecznosc();
    KatalogWypozyczen katalog = new KatalogWypozyczen();
    {
        //-------------------------Samochody w bazie(symulacja garażu)----------------------------------------------------
        garaz.dodajAuto("Opel", "Astra", "TKI 48125", 2008, "benzyna", false);
        garaz.dodajAuto("Opel", "Insignia", "TKI 21835", 2014, "benzyna + LPG", true);
        garaz.dodajAuto("Skoda", "Octavia", "TKI 31478", 2017, "diesel", false);
        //-------------------------Osoby w bazie(symulacja społeczności)----------------------------------------------------
        spolecznosc.addPerson("Jan1","Kowalski1",123456789, Date.valueOf("1999-05-28"),12345678910L,'M');
        spolecznosc.addPerson("Jan1","Kowalski1",125601782, Date.valueOf("1997-01-17"),12345678911L,'K');
        spolecznosc.addPerson("Jan2","Kowalski2",987654321, Date.valueOf("1998-09-30"),12345678912L,'M');
        //-------------------------Wypożyczenia w bazie(symulacja katalogu wypożyczeń)----------------------------------------------------
        katalog.dodajWypozyczenie("Opel","Astra H",Date.valueOf("1999-05-28"),Date.valueOf("1999-05-30"),"Jan","Nowak",12345678910L);
        katalog.dodajWypozyczenie("Skoda","Octavia",Date.valueOf("2003-05-28"),Date.valueOf("2008-05-30"),"Robert","Kowalski",93345678910L);
        katalog.dodajWypozyczenie("Audi","A4",Date.valueOf("2000-05-28"),Date.valueOf("2000-05-30"),"Stanislaw","Rak",12345654910L);
    }

    //ObservableList<String> marka = FXCollections.observableArrayList("Fiat","Opel","Skoda","Toyota","VolksWagen");
    ObservableList<String> marka = FXCollections.observableArrayList();
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
    private void initialize() {

        for(int i = 0; i < garaz.ileAut(); i++) {
                marka.add(garaz.getAuto(i).getMarka());
        }
        for(int i = 0; i < garaz.ileAut(); i++) {
                System.out.println(marka.get(i));
        }

        //wybór paliwa
        fuelChoise1.setValue("Benzyna");
        fuelChoise1.setItems(paliwo);
        //wybór marki
        brandCarChoise2.setValue(marka.get(0));
        brandCarChoise2.setItems(marka);
        brandCarChoiseZ2.setValue(marka.get(0));
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
    private void createAccount(){
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

            spolecznosc.addPerson(imie,nazwisko,nrTel,dataUro,nrPesel,plec);
        }
        else
        {
            alert.setContentText("Akceptacja regulaminu jest obowiązkowa!");;
        }
        spolecznosc.wyswietlSpolecznosc();

        alert.showAndWait();
    }

    @FXML
    private void addCar(){
        String marka = String.valueOf(carBrandField1.getCharacters());
        String model = String.valueOf(modelField1.getCharacters());
        String nrRejestracyjny = String.valueOf(registrationNumberField1.getCharacters());
        int rocznik = Integer.parseInt(String.valueOf(yearField1.getCharacters()));
        String fuel = String.valueOf(fuelChoise1.getValue());
        boolean hak = haveHookBox1.isSelected();

        garaz.dodajAuto(marka,model,nrRejestracyjny,rocznik,fuel,hak);
        garaz.wyswietlGaraz();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText(marka + " " + model + " " + nrRejestracyjny + " " + "został dodany");

        alert.showAndWait();
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

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText(marka + " " + model + " na " + iloscDob + " dni " + "kosztuje: ");

        alert.showAndWait();
    }

    @FXML
    private void hireCar(){
        String marka = String.valueOf(brandCarChoise2.getValue());
        String model = String.valueOf(modelCarChoise2.getValue());
        Date dataWypozyczenia = Date.valueOf(borrowDatePicker2.getValue());
        Date dataOddania = Date.valueOf(backDatePicker2.getValue());
        String imieWyp = String.valueOf(nameFieldW2.getCharacters());
        String nazwiskoWyp = String.valueOf(lastNameFieldW2.getCharacters());
        Long peselWyp = Long.valueOf(String.valueOf(peselNumberField2.getCharacters()));

        katalog.dodajWypozyczenie(marka,model,dataWypozyczenia,dataOddania,imieWyp,nazwiskoWyp,peselWyp);
        katalog.wyswietlKatalogWypozyczen();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText(marka + " " + model + " od dnia " + dataWypozyczenia + " do dnia " + dataOddania + " został wypożyczony!");

        alert.showAndWait();
    }


    /*public void wyswietlKomunikat(Event event) {
        System.out.println(event.getSource());
        System.out.println("Przycisk działa !");
    }*/
}
