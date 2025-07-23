package coffee;

import java.sql.*;

public class StoredProcedure {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/new_schema";
        String username = "root";
        String password = "Rashagan6@";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password)) {
            CallableStatement stmt = conn.prepareCall("{CALL InsertStudent(?, ?, ?, ?)}");

            stmt.setInt(1, 101); // id
            stmt.setInt(2, 20); // age
            stmt.setString(3, "John Doe"); // name
            stmt.setInt(4, 102); // rollno

            stmt.execute();
            System.out.println("Student inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}