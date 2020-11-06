package grafika.aplikacja;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public void start(Stage primaryStage) throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("pracownik.fxml"));
        primaryStage.setTitle("Wypożyczalnia aut");
        primaryStage.setScene(new Scene(root1, 640, 480));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

