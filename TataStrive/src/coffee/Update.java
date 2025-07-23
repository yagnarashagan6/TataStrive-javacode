package coffee;

import java.sql.*;

public class Update {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";  // Initial connection without database
        String user = "root";
        String password = "Rashagan6@";
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(url,user,password);
        	Statement stmt = conn.createStatement();
        	String updatesql1 = "UPDATE employees SET job = 'data science' WHERE id= 2";
        	stmt.executeUpdate(updatesql1);
        	String updatesql2 = "UPDATE employees SET job = 'data analyst' WHERE id= 103";
        	stmt.executeUpdate(updatesql2);
        	String updatesql3 = "UPDATE employees SET job = 'ml engineer' WHERE id= 104";
        	stmt.executeUpdate(updatesql3);
        	String updatesql4 = "UPDATE employees SET job = 'software developer' WHERE id= 105";
        	stmt.executeUpdate(updatesql4);
        	System.out.println("rows updated successfully!");
        	stmt.close();
        	conn.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }
}
