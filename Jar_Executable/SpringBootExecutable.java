package Jar_Executable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpringBootExecutable implements Runnable {

    //Find a way to send deck data from the console application Spring Boot Application

    public SpringBootExecutable() {
        run();
    }

    public void run() {
        try {
            // Define the URL of the Spring Boot endpoint
            String url = "http://localhost:8080/hello"; // Replace with your Spring Boot app's URL

            // Create a URL object
            URL springBootUrl = new URL(url); 

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) springBootUrl.openConnection();

            try {
                // Set the request method to GET
                connection.setRequestMethod("GET");

                // Get the response code
                int responseCode = connection.getResponseCode();
                System.out.println("Response Code: " + responseCode);

                // Read the response data
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    System.out.println("Response Data: " + response.toString());
                } else {
                    System.err.println("HTTP Request Failed");
                }
            } finally {
                // Close the connection
                connection.disconnect();
            }
        } catch (IOException e) {
            // Handle IOException (e.g., log the error or take corrective action)
            e.printStackTrace();
        }
    }
}