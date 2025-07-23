package coffee;

import java.sql.*;

public class Insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
        String user = "root";
        String password = "Rashagan6@";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

        
            String sql = "INSERT INTO employees (id, age, name, salary, job) VALUES (106, 25, 'vikram', 55000.00, 'Backend Developer')";
            int rowsInserted = stmt.executeUpdate(sql);
            System.out.println(rowsInserted + " employees inserted successfully!");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}