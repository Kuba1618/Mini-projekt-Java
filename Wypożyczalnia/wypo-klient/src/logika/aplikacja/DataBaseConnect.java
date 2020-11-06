package logika.aplikacja;

import java.sql.*;

public class DataBaseConnect {

    private Connection myConnection;
    private Statement myStatement;
    private ResultSet myResultSet;

    public DataBaseConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wypozyczalnia","root","");
            myStatement = myConnection.createStatement();


        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void getData() {
        try {
            String query = "SELECT * FROM `osoby`;";
            myResultSet = myStatement.executeQuery(query);
            System.out.println("Moje dane: ");
            while(myResultSet.next()) {
                String name = myResultSet.getString("Imie");
                System.out.println(name);
            }
        }
        catch(Exception ex) {
            System.out.println(ex);

        }
    }
}
