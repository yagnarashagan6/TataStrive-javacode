package coffee;
import java.sql.*;

public class Table {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/?useSSL=false";  // Initial connection (no DB)
        String user = "root";
        String password = "Rashagan6@";

        try {
            // Step 1: Connect to MySQL server (no database yet)
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Step 2: Create database if not exists
            String dbName = "supermarketdb";
            String createDb = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.executeUpdate(createDb);
            System.out.println("Database '" + dbName + "' created (or already exists).");

            // Step 3: Connect to the new database
            conn.close();
            url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            // Step 4: Create table D_Mart
            String createTable = "CREATE TABLE IF NOT EXISTS D_Mart ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "productname VARCHAR(100), "
                    + "quantity INT, "
                    + "price FLOAT"
                    + ")";
            stmt.executeUpdate(createTable);
            System.out.println("Table 'D_Mart' created successfully!");

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
