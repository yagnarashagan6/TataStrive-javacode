package coffee;

import java.sql.*;

public class Delete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
        String user = "root";
        String password = "Rashagan6@";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

 
            String sql = "DELETE FROM employees WHERE id = 105";
            int rowsDeleted = stmt.executeUpdate(sql);
            System.out.println(rowsDeleted + " employee(s) deleted successfully!");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}