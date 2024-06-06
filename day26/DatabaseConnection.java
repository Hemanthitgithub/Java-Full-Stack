package day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_db";
	static final String USERNAME = "root";
	static final String PASSWORD = "root@1234";


	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME,PASSWORD);
			System.out.println("Connected to the database: "+ connection);
			connection.close();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}