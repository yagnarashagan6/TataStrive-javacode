package coffee;

import java.sql.*;
import java.util.Scanner;

public class AddColumnByInput {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/marvel?useSSL=false";
        String user = "root";
        String password = "Rashagan6@";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new column name: ");
        String columnName = scanner.nextLine();

        System.out.print("Enter data type (e.g., VARCHAR(50), INT, DOUBLE): ");
        String columnType = scanner.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // ⚠️ Build SQL from input safely — no semicolon at the end!
            String sql = "ALTER TABLE heroes ADD COLUMN " + columnName + " " + columnType;
            stmt.executeUpdate(sql);

            System.out.println("Column '" + columnName + "' added successfully as type " + columnType + "!");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Something went wrong—check your input and try again.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE Students (" +
                         "id INT NOT NULL AUTO_INCREMENT, " +
                         "name VARCHAR(100), " +
                         "age INT, " +
                         "PRIMARY KEY (id))";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}