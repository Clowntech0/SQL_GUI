package SQLGUI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Scanner;


public class SQLGUI{

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/driveeasyrentals";

    public static void main(String[] args){
        //https://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-connect-drivermanager.html#connector-j-examples-connection-drivermanager

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Application app = new Application();
                    app.frame.setVisible(true);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static Connection connectToDatabase(String databaseURL, String username, String password){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return connection;
    }

}



