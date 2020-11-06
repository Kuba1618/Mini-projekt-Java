package grafika.aplikacja;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class ControllerZ {

    ObservableList<String> marka = FXCollections.observableArrayList("Fiat","Opel","Skoda","Toyota","VolksWagen");
    ObservableList<String> model = FXCollections.observableArrayList("Tipo","Astra H","Octavia","Yaris","Golf IV");
    ObservableList<String> dni = FXCollections.observableArrayList("10","20","30","50","100");

    @FXML
    private ChoiceBox brandCarChoiseZ2;
    @FXML
    private ChoiceBox modelCarChoiseZ2;
    @FXML
    private ChoiceBox howDaysChoiseZ2;

    @FXML
    private void initialize(){
        //wybór marki

         brandCarChoiseZ2.setValue("VolksWagen");
        brandCarChoiseZ2.setItems(marka);

        //wybór modelu
        modelCarChoiseZ2.setValue("Golf IV");
        modelCarChoiseZ2.setItems(model);

        //na ile dni wypozyczyc auto
        howDaysChoiseZ2.setValue("30");
        howDaysChoiseZ2.setItems(dni);
    }

    public void wyswietlKomunikat(Event event) {
        System.out.println(event.getSource());
        System.out.println("Przycisk działa !");
    }
}
