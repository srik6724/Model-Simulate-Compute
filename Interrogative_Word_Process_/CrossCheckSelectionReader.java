package Interrogative_Word_Process_;


import java.io.FileReader;
import java.io.IOException;

class CrossCheckSelectionReader {
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 

  CrossCheckSelectionReader(String team, int round) {
    try {
      file_reader = Cross_Check_Selection.getFileReader(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team, int round) {
    if(CrossCheckSelectionReader.readerCreated == false) {
      System.out.println("Calling selection_line reader constructor."); 
      new CrossCheckSelectionReader(team, round); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    CrossCheckSelectionReader.readerCreated = var; 
  }
}
