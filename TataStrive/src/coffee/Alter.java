package coffee;

import java.sql.*;

public class Alter {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";  // Initial connection without database
        String user = "root";
        String password = "Rashagan6@";
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(url,user,password);
        	Statement stmt = conn.createStatement();
            // Step 1: Drop existing 'id' column
            String dropIdSql = "ALTER TABLE employees DROP COLUMN id";
            stmt.executeUpdate(dropIdSql);

            // Step 2: Add new 'id' column with AUTO_INCREMENT
            String addIdSql = "ALTER TABLE employees ADD COLUMN id INT NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
            stmt.executeUpdate(addIdSql);

            System.out.println("Old 'id' column removed and new AUTO_INCREMENT 'id' column added!");


        	System.out.println("rows updated successfully!");
        	stmt.close();
        	conn.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }
}
