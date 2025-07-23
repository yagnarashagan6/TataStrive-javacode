package coffee;
import java.sql.*;
import java.util.Scanner;
public class DataBase {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/?useSSL=false";  // Initial connection without database
        String user = "root";
        String password = "Rashagan6@";
        try {
   
        	Connection conn = DriverManager.getConnection(url,user,password);
        	Statement stmt = conn.createStatement();
        	System.out.print("Enter the DataBase name: ");
        	Scanner sc = new Scanner(System.in);
        	String a = sc.next();
        	String sql = "CREATE DATABASE "+a;
        	stmt.executeUpdate(sql);
        	System.out.println("database "+a+" created successfully!");
        	stmt.close();
        	conn.close();
        }catch (Exception e) {
        	e.printStackTrace();
        }
	}

}
