package Second_Process;

import java.io.FileReader;
import java.io.IOException;

public class MicrosecondOfSpellsReader {
  // Reads a round using the file_reader
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 
  
  MicrosecondOfSpellsReader() {
    try {
      file_reader = Microsecond_Interpreter.getFileReader();
      MicrosecondOfSpellsReader.readerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader() {
    if(MicrosecondOfSpellsReader.readerCreated == false) {
      System.out.println("Calling round_reader constructor."); 
      new MicrosecondOfSpellsReader(); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean b) {
    MicrosecondOfSpellsReader.readerCreated = b;
  }



}
