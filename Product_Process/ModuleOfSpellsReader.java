package Product_Process;

import java.io.FileReader;
import java.io.IOException;

public class ModuleOfSpellsReader {
  // Reads a round using the file_reader
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 
  
  ModuleOfSpellsReader() {
    try {
      file_reader = Module_Interpreter.getFileReader();
      ModuleOfSpellsReader.readerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader() {
    if(ModuleOfSpellsReader.readerCreated == false) {
      System.out.println("Calling round_reader constructor."); 
      new ModuleOfSpellsReader(); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean b) {
    ModuleOfSpellsReader.readerCreated = b;
  }



}
