package grafika.aplikacja;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class Controller {

    ObservableList<String> paliwo = FXCollections.observableArrayList("Benzyna","Diesel","Benzyna + LPG");
    ObservableList<String> marka = FXCollections.observableArrayList("Fiat","Opel","Skoda","Toyota","VolksWagen");
    ObservableList<String> model = FXCollections.observableArrayList("Tipo","Astra H","Octavia","Yaris","Golf IV");
    ObservableList<String> dni = FXCollections.observableArrayList("10","20","30","50","100");

    //Okno PPP(pracownika)
    @FXML
    private ChoiceBox fuelChoise1;
    @FXML
    private ChoiceBox brandCarChoise2,brandCarChoise3,brandCarChoiseZ2;
    @FXML
    private ChoiceBox modelCarChoise2,modelCarChoise3,modelCarChoiseZ2;
    //ZZZ
    @FXML
    private ChoiceBox howDaysChoiseZ2;


    @FXML
    private void initialize(){
        //wybór paliwa
        fuelChoise1.setValue("Benzyna");
        fuelChoise1.setItems(paliwo);
        //wybór marki
        brandCarChoise2.setValue("VolksWagen");
        brandCarChoise2.setItems(marka);
        brandCarChoise3.setValue("VolksWagen");
        brandCarChoise3.setItems(marka);/*
        brandCarChoiseZ2.setValue("VolksWagen");
        brandCarChoiseZ2.setItems(marka);*/

        //wybór marki

        modelCarChoise2.setValue("Golf IV");
        modelCarChoise2.setItems(model);
        modelCarChoise3.setValue("Golf IV");
        modelCarChoise3.setItems(model);/*
        modelCarChoiseZ2.setValue("Golf IV");
        modelCarChoiseZ2.setItems(model);

        //na ile dni wypozyczyc auto
        howDaysChoiseZ2.setValue("30");
        howDaysChoiseZ2.setItems(dni);*/
    }

    public void wyswietlKomunikat(Event event) {
        System.out.println(event.getSource());
        System.out.println("Przycisk działa !");
    }
}
