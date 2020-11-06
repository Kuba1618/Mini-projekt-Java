package grafika.aplikacja;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.awt.*;
import java.sql.Date;

public class ControllerP {

    ObservableList<String> paliwo = FXCollections.observableArrayList("Benzyna","Diesel","Benzyna + LPG");
    ObservableList<String> marka = FXCollections.observableArrayList("Fiat","Opel","Skoda","Toyota","VolksWagen");
    ObservableList<String> model = FXCollections.observableArrayList("Tipo","Astra H","Octavia","Yaris","Golf IV");
    ObservableList<String> rejestracja = FXCollections.observableArrayList("TKI 12345","TK 84GF");

    //---------------ChoiceBox-----------------------
    @FXML
    private ChoiceBox fuelChoise1;
    @FXML
    private ChoiceBox brandCarChoise2,brandCarChoise3;
    @FXML
    private ChoiceBox modelCarChoise2,modelCarChoise3;
    @FXML
    private ChoiceBox registerNumberChoise3;
    //---------------TextField------------------------
    @FXML
    private TextField carBrandField1;
    @FXML
    private TextField modelField1;
    @FXML
    private TextField registrationNumberField1;
    @FXML
    private TextField yearField1;
    @FXML
    private TextField idendityField2;
    //--------------DatePicker------------------
    @FXML
    private DatePicker borrowDatePicker2;
    @FXML
    private DatePicker backDatePicker2;
    //--------------CheckBox--------------------
    @FXML
    private CheckBox haveHookBox1;



    @FXML
    private void initialize(){
        //wybór paliwa
        fuelChoise1.setValue("Benzyna");
        fuelChoise1.setItems(paliwo);
        //wybór marki
        brandCarChoise2.setValue("VolksWagen");
        brandCarChoise2.setItems(marka);
        brandCarChoise3.setValue("VolksWagen");
        brandCarChoise3.setItems(marka);
        //wybór marki
        modelCarChoise2.setValue("Golf IV");
        modelCarChoise2.setItems(model);
        modelCarChoise3.setValue("Golf IV");
        modelCarChoise3.setItems(model);
        //wybór rejestracji
        registerNumberChoise3.setValue("TKI 12345");
        registerNumberChoise3.setItems(rejestracja);
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
    private void checkCar(){
        String marka = String.valueOf(brandCarChoise3.getValue());
        String model = String.valueOf(modelCarChoise3.getValue());

        System.out.print("Marka:" + marka + "  Model:" + model );

    }


    /*public void wyswietlKomunikat(Event event) {
        System.out.println(event.getSource());
        System.out.println("Przycisk działa !");
    }*/
}
