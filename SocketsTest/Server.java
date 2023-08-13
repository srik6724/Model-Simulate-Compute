package SocketsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(12345)) {
        System.out.println("Server listening on port 12345...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Process the client's request
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String clientMessage = reader.readLine();
                System.out.println("Received from client: " + clientMessage);

                // Respond to the client
                writer.println("Hello from server!");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clientSocket.close();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
