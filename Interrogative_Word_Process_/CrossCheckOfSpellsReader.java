package Interrogative_Word_Process_;

import java.io.FileReader;
import java.io.IOException;

public class CrossCheckOfSpellsReader {
  // Reads a round using the file_reader
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 
  
  CrossCheckOfSpellsReader() {
    try {
      file_reader = Cross_Check_Interpreter.getFileReader();
      CrossCheckOfSpellsReader.readerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader() {
    if(CrossCheckOfSpellsReader.readerCreated == false) {
      System.out.println("Calling round_reader constructor."); 
      new CrossCheckOfSpellsReader(); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean b) {
    CrossCheckOfSpellsReader.readerCreated = b;
  }



}
