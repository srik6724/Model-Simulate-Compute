package wizPackage;


import java.io.FileReader;
import java.io.IOException;

class RoundSelectionLineReader {
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 

  RoundSelectionLineReader(String team, int round) {
    try {
      file_reader = Round_Selection_Line_Path.getFileReader(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team, int round) {
    if(RoundSelectionLineReader.readerCreated == false) {
      System.out.println("Calling selection_line reader constructor."); 
      new RoundSelectionLineReader(team, round); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    RoundSelectionLineReader.readerCreated = var; 
  }
}
