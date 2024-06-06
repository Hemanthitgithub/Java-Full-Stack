package day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecureQuery {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "root@1234";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                retrieveUserData(connection, "exampleUser");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void retrieveUserData(Connection connection, String userId) throws SQLException {
        String selectSQL = "SELECT * FROM User WHERE UserID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("UserID: " + resultSet.getString("UserID") +
                                       ", PasswordHash: " + resultSet.getString("PasswordHash"));
                }
            }
        }
    }
}