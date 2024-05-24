package DeckFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DeckFileDirectory {
  public static void main(String[]args)
  {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("C:/Users/srik6/Downloads/sometxtfile.txt"));
      char[] buffer = new char[10];  // Your buffer size
  
      int numCharsRead;
      while ((numCharsRead = reader.read(buffer, 0, buffer.length)) != -1) {
          String line = new String(buffer, 0, numCharsRead);
          System.out.println(line);
      }
      reader.close();
  } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
