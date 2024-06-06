package day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserAuthentication {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "root@1234";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                createTable(connection);
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter User ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                if (authenticateUser(connection, userId, password)) {
                    System.out.println("User access allowed.");
                } else {
                    System.out.println("Invalid User ID or Password.");
                }

                scanner.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS User (" +
                                "UserID VARCHAR(50) PRIMARY KEY, " +
                                "PasswordHash VARCHAR(64))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean authenticateUser(Connection connection, String userId, String password) throws SQLException {
        String hashedPassword = hashPassword(password);
        String selectSQL = "SELECT * FROM User WHERE UserID = ? AND PasswordHash = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, hashedPassword);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
}