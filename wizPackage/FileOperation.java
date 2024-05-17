package wizPackage;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

class FileOperation implements Runnable {

  private BufferedReader reader; 
  private FileWriter writer; 

  FileOperation(BufferedReader reader, FileWriter writer) {
    this.reader = reader; 
    this.writer = writer; 
  }

  @Override
  public void run() {
    // Reading lines from the reader
    try {
      String line; 
      while((line = reader.readLine()) != null) {
        System.out.println("Reading out each line: " + line); 
        System.exit(0); 
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  

  
}
