package Match_Process;

import java.io.FileReader;
import java.io.IOException;

public class RoundOfSpellsReader {
  // Reads a round using the file_reader
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 
  
  RoundOfSpellsReader() {
    try {
      file_reader = Round_Interpreter.getFileReader();
      RoundOfSpellsReader.readerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader() {
    if(RoundOfSpellsReader.readerCreated == false) {
      System.out.println("Calling round_reader constructor."); 
      new RoundOfSpellsReader(); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean b) {
    RoundOfSpellsReader.readerCreated = b;
  }



}
