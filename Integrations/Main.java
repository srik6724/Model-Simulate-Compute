import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Main {
   public static void main(String[] args) throws InterruptedException {
        try {
            // Define the path to the C++ executable
            String cplusplusExecutable;

            // Check if running on Windows
            String osName = System.getProperty("os.name").toLowerCase();

            if (osName.contains("win")) {
                cplusplusExecutable = "C:/Users/srik6/OneDrive/Desktop/Match (Model, Simulate, Compute)/Match-Build/Integrations/entity_linker.exe"; // Windows executable
            } else {
                cplusplusExecutable = "./entity_linker"; // Unix-based executable 
            }

            // Create the process builder
            ProcessBuilder pb = new ProcessBuilder(cplusplusExecutable);

            // Start the process
            Process process = pb.start();

            OutputStream outputStream = process.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            // Write data to the C++ program
            writer.write("Data from Java\n");
            writer.flush(); // Flush the buffer to ensure data is sent

            // Close the writer
            writer.close();

            // Stream the output to the terminal
            streamOutput(process.getInputStream());
            process.destroy();
            //System.out.println("Done with execution.");
            //streamOutput(process.getErrorStream());

            // Wait for the process to complete (optional)
            //process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void streamOutput(InputStream inputStream) {
            try {
                int read;
                byte[] buffer = new byte[4096];
                while ((read = inputStream.read(buffer)) != -1) {
                    String data = new String(buffer, 0, read);
                    System.out.print(data);
                }
                System.exit(0); 
            } catch (IOException e) {
                e.printStackTrace(); 
            }
        
    }
}
