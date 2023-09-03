package SpringBoot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import javax.xml.ws.spi.http.HttpContext;

public class SpringBootExecutable implements Runnable {
  public SpringBootExecutable() throws InterruptedException, IOException
  {
    run(); 
  }

  public void run()
  {
    try {
      // Create a URL object for the endpoint you want to request
      URL url = new URL("http://localhost:8080/api/someEndpoint"); // Replace with your endpoint URL

      // Open a connection to the URL
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set the HTTP request method (GET, POST, etc.)
      connection.setRequestMethod("GET");

      // Read the response from the server
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
          response.append(line);
      }
      reader.close();

      // Print the response
      System.out.println("Response: " + response.toString());

      // Close the connection
      connection.disconnect();
  } catch (Exception e) {
      e.printStackTrace();
  }
}
}