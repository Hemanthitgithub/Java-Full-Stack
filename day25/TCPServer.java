package day25;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

                    Operation operation = (Operation) in.readObject();
                    int result = operation.getResult();
                    out.writeObject(result);

                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}