package SQLGUI;
import java.sql.*;
import java.util.Scanner;


public class SQLGUI{

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/driveeasyrentals";

    public static void main(String[] args){
        //https://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-connect-drivermanager.html#connector-j-examples-connection-drivermanager
        //Connect to database
        Scanner scnr = new Scanner(System.in);
        String username = scnr.nextLine();
        String password = scnr.nextLine();

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SHOW TABLES");
            while (rs.next()) {
                // rs.getString(1) retrieves the first column (table name)
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }


        int i = scnr.nextInt();
    }
}
