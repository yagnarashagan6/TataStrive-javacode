package coffee;
import java.sql.*;
import java.util.Scanner;

public class Supermarket {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/?useSSL=false";  
        String user = "root";
        String password = "Rashagan6@";
        Scanner sc = new Scanner(System.in);

        try {
            // Step 1: Connect to MySQL
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Step 2: Create database
            System.out.print("Enter the Database name: ");
            String dbName = sc.next();
            String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.executeUpdate(sql);
            System.out.println("Database " + dbName + " created successfully!");

            // Step 3: Reconnect to the database
            conn.close();
            url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            // Step 4: Create table
            System.out.print("Enter the Table name: ");
            String tableName = sc.next();

            System.out.print("Enter the number of columns (excluding id): ");
            int numCols = sc.nextInt();

            // Build query with id as primary key by default
            StringBuilder tableQuery = new StringBuilder("CREATE TABLE IF NOT EXISTS `" + tableName + "` (");
            tableQuery.append("id INT PRIMARY KEY AUTO_INCREMENT");

            for (int i = 1; i <= numCols; i++) {
                System.out.print("Enter name for column " + i + ": ");
                String colName = sc.next();
                System.out.print("Enter type for column " + i + " (e.g., INT, VARCHAR(50)): ");
                String colType = sc.next();

                tableQuery.append(", ").append(colName).append(" ").append(colType);
            }
            tableQuery.append(");");

            stmt.executeUpdate(tableQuery.toString());
            System.out.println("Table " + tableName + " created successfully with `id` as PRIMARY KEY!");

            stmt.close();
            conn.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
