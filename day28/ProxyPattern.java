package day28;

public class ProxyPattern {
    private String secretKey;
    private final String password;

    public ProxyPattern(String secretKey, String password) {
        this.secretKey = secretKey;
        this.password = password;
    }

    public String getSecretKey(String inputPassword) {
        if (inputPassword.equals(password)) {
            return secretKey;
        } else {
            throw new SecurityException("Incorrect password");
        }
    }

    // Additional method to update the secret key, requires password verification
    public void updateSecretKey(String newKey, String inputPassword) {
        if (inputPassword.equals(password)) {
            this.secretKey = newKey;
            System.out.println("Secret key updated successfully");
        } else {
            throw new SecurityException("Incorrect password");
        }
    }

    public static void main(String[] args) {
        // Example usage
        String initialSecretKey = "initialSecret";
        String password = "myPassword";
        ProxyPattern proxy = new ProxyPattern(initialSecretKey, password);

        // Attempt to access the secret key
        try {
            String inputPassword = "myPassword";
            String retrievedKey = proxy.getSecretKey(inputPassword);
            System.out.println("Secret key: " + retrievedKey);
        } catch (SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Attempt to access the secret key with incorrect password
        try {
            String inputPassword = "wrongPassword";
            String retrievedKey = proxy.getSecretKey(inputPassword);
            System.out.println("Secret key: " + retrievedKey);
        } catch (SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Attempt to update the secret key with correct password
        try {
            String newKey = "newSecretKey";
            String inputPassword = "myPassword";
            proxy.updateSecretKey(newKey, inputPassword);
        } catch (SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Attempt to update the secret key with incorrect password
        try {
            String newKey = "newSecretKey";
            String inputPassword = "wrongPassword";
            proxy.updateSecretKey(newKey, inputPassword);
        } catch (SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}