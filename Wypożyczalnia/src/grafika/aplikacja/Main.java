package grafika.aplikacja;
import logika.aplikacja.Auto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pracownik.fxml"));
        primaryStage.setTitle("Wypożyczalnia aut");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();

        Auto a1 = new Auto("Opel","Astra","TKI 48125",2008,112.345);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

