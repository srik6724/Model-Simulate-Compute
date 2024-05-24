package wizPackage;

import java.io.FileReader;
import java.io.IOException;

class MatchSelectionLineReader {
  private static boolean readerCreated = false;
  private static FileReader file_reader;
  
  MatchSelectionLineReader(String team) {
    try {
      file_reader = Match_Selection_Line_Path.getFileReader(team);
      MatchSelectionLineReader.readerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team) {
    if(MatchSelectionLineReader.readerCreated == false) {
      System.out.println("Calling match_reader constructor.");
      new MatchSelectionLineReader(team);
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    MatchSelectionLineReader.readerCreated = var; 
  }
}
