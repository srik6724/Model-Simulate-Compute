package Domain_Process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
  public static void main(String[]args) {
    String domain = "https://enigmaidentity.com"; 
    int port = 80; 

    try {
      InetAddress address = InetAddress.getByName(domain); 
      Socket socket = new Socket(address, port); 

      InputStream inputStream =  socket.getInputStream(); 
      OutputStream outputStream = socket.getOutputStream(); 

      PrintWriter out = new PrintWriter(outputStream, true); 
      out.println("GET / HTTP/1.1"); 
      out.println("Host: " + domain); 
      out.println(); 

      BufferedReader in = new BufferedReader(new InputStreamReader(inputStream)); 
      String response; 
      while ((response = in.readLine()) != null) {
        System.out.println(response); 
      }

      socket.close(); 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }
}
