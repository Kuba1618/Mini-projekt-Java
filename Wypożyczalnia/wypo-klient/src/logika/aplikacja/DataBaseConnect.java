package logika.aplikacja;

import java.sql.*;

public class  DataBaseConnect {

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
            //myStatement.close();
        }
        catch(Exception ex) {
            System.out.println(ex);

        }
    }
    //public void setData(int id,String imie,String nazwisko,int telefon,Date urodziny,long pesel,char plec) {
    public void setData(int i, String agnieszka, String doborowicz, int i1, Date date, long l, char k) {
        try {
            Statement stmt = myConnection.createStatement();
            //String sql = "insert into 'osoby'(`Id`,`Imie`,`Nazwisko`,`Telefon`,`Data Urodzenia`,`PESEL`,`Płeć`) " +
              //      "VALUES (" + id + ",`"+ imie +"`,`"+ nazwisko +"`,"+ telefon +",`" + urodziny +"`,"+ pesel
                //    + ",`"+ plec +"`);";
            Date urodziny = Date.valueOf("1985-09-28");
            String sql = "INSERT INTO `osoby`(`Id`, `Imie`, `Nazwisko`, `Telefon`, `Data Urodzenia`, `PESEL`, `Płeć`)" +
                         "VALUES (202,\"Mateusz\",\"Kaniecki\",456132821,\""+urodziny+"\",97864512354,\"M\");";
            stmt.execute(sql);
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
