package grafika.aplikacja;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;

public class ControllerZ {

    ObservableList<String> marka = FXCollections.observableArrayList("Fiat","Opel","Skoda","Toyota","VolksWagen");
    ObservableList<String> model = FXCollections.observableArrayList("Tipo","Astra H","Octavia","Yaris","Golf IV");
    ObservableList<String> dni = FXCollections.observableArrayList("10","20","30","50","100");


    @FXML
    private ChoiceBox brandCarChoiseZ2,modelCarChoiseZ2,howDaysChoiseZ2;
    @FXML
    private TextField nameFieldZ1,lastNameFieldZ1,phoneFieldZ1;
    @FXML
    private DatePicker dateOfBirthCalendarZ1;
    @FXML
    private RadioButton womanRadioButtonZ1,manRadioButtonZ1;
    @FXML
    private CheckBox acceptBoxZ1,fotelikBoxZ2,extraInsuaranceBoxZ2,bagaznikNartyBoxZ2;
    /* @FXML
    private Button registerButtonZ1,checkButtonZ2;
    */



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
    private void checkCar(){
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
