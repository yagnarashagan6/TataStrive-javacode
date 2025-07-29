package coffee;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/?useSSL=false";  // Initial connection without database
        String user = "root";
        String password = "Rashagan6@";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS employee");
            System.out.println("✅ Database created");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useSSL=false", user, password);
            stmt = conn.createStatement();

            String query = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Dynamically display column headers
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s", meta.getColumnName(i));
            }
            System.out.println();

            // Dynamically display rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    System.out.printf("%-15s", value);
                }
                System.out.println();
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}