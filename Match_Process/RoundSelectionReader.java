package Match_Process;


import java.io.FileReader;
import java.io.IOException;

class RoundSelectionReader {
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 

  RoundSelectionReader(String team, int round) {
    try {
      file_reader = Round_Selection.getFileReader(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team, int round) {
    if(RoundSelectionReader.readerCreated == false) {
      System.out.println("Calling selection_line reader constructor."); 
      new RoundSelectionReader(team, round); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    RoundSelectionReader.readerCreated = var; 
  }
}
