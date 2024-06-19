import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args) {
        try {
            // Define the path to the C++ executable
            String cplusplusExecutable;

            // Check if running on Windows
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("win")) {
                cplusplusExecutable = "C:/Users/srik6/OneDrive/Desktop/Match (Model, Simulate, Compute)/Match-Build/Integrations/example.exe"; // Windows executable
            } else {
                cplusplusExecutable = "./example"; // Unix-based executable
            }

            // Create the process builder
            ProcessBuilder pb = new ProcessBuilder(cplusplusExecutable);

            // Start the process
            Process process = pb.start();

            // Stream the output to the terminal
            int x = streamOutput(process.getInputStream());
            System.out.println("X value: " + x);
            process.destroy();
            System.out.println("Done with execution.");
            //streamOutput(process.getErrorStream());

            // Wait for the process to complete (optional)
            //process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int streamOutput(InputStream inputStream) {
        final int x = 1; 
        new Thread(() -> {
            try {
                int read;
                byte[] buffer = new byte[4096];
                while ((read = inputStream.read(buffer)) != -1) {
                    System.out.write(buffer, 0, read);
                    System.out.println("Value of x: " + x);
                    break;
                }
                System.exit(0); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        
        return x;
    }
}
