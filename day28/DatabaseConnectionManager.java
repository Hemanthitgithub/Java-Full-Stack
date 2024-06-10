package day28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
	private static DatabaseConnectionManager instance;
	
	private Connection connection;
	
	private final String url = "jdbc:mysql://localhost:3306/yourdatabase";
	private final String username = "yourusername";
	private final String password = "yourpassword";
	
	private DatabaseConnectionManager() {
		try {
			this.connection = DriverManager.getConnection(url,username,password);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error connecting to the database",e);
		}
	}
	public static synchronized DatabaseConnectionManager getInstance() {
		if(instance == null) {
			instance = new DatabaseConnectionManager();
		}
		return instance;
	}
	public Connection getConnection() {
		return connection;
	}
	

	public static void main(String[] args) {
		DatabaseConnectionManager manager = DatabaseConnectionManager.getInstance();
		Connection conn = manager.getConnection();
		System.out.println("Database connection established:"+(conn != null));
		
		// TODO Auto-generated method stub

	}

}
