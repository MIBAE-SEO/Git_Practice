package memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Customer {

	public static void main(String[] args) {
		
		getConnection();
	}
	    
	
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS"
					+ "customer(id int NOT NULL, AUTO_INCREMENT,"
					+ "name VARCHAR(225),"
					+ "age VARCHAR(225),"
					+ "gender VARCHAR(225),"
					+ "phone VARCHAR(225),"
					+ "address VARCHAR(225),"
					+ "PRIMARY KEY(id))"); //전달할 내용 넣기 
			createTable.execute();
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally {
			System.out.println("Table successfully created");
		}
		
	}
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10349128";
			String user = "sql10349128";
			String pass = "SYVIYfJlsI";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("The Connection Successful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
		
}
