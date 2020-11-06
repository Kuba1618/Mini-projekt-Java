package grafika.aplikacja;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logika.aplikacja.DataBaseConnect;

import java.sql.Date;


public class Main extends Application {

    public void start(Stage primaryStage) throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("pracownik.fxml"));
        primaryStage.setTitle("Wypożyczalnia aut");
        primaryStage.setScene(new Scene(root1, 350, 460));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        DataBaseConnect connection = new DataBaseConnect();
        connection.getData();
        connection.setData(117,"Agnieszka","Doborowicz",465219872, Date.valueOf("1988-05-02"),12395432876l,'k');//117,"Agnieszka","Doborowicz",465219872, Date.valueOf("1988-05-02"),46579813128l,'k'
    }

}

