package day25;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            Operation operation = new Operation(5, 5, "+");
            out.writeObject(operation);

            int result = (int) in.readObject();
            System.out.println("Result from server: " + result);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}