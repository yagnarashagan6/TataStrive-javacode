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

            System.out.println("\n------------------ Employee Table ----------------------");
            System.out.printf("%-5s %-5s %-12s %-10s %-12s%n", "id", "age", "name", "salary", "job");
            System.out.println("--------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                String job = rs.getString("job");

                System.out.printf("%-5d %-5d %-12s %-10.2f %-12s%n", id, age, name, salary, job);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}