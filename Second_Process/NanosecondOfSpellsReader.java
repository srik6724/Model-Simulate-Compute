package Second_Process;

import java.io.FileReader;
import java.io.IOException;

public class NanosecondOfSpellsReader {
  // Reads a round using the file_reader
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 
  
  NanosecondOfSpellsReader() {
    try {
      file_reader = Nanosecond_Interpreter.getFileReader();
      NanosecondOfSpellsReader.readerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader() {
    if(NanosecondOfSpellsReader.readerCreated == false) {
      System.out.println("Calling round_reader constructor."); 
      new NanosecondOfSpellsReader(); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean b) {
    NanosecondOfSpellsReader.readerCreated = b;
  }



}
