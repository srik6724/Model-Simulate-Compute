package Match_Process;

import java.io.FileReader;
import java.io.IOException;

class MatchSelectionReader {
  private static boolean readerCreated = false;
  private static FileReader file_reader;
  
  MatchSelectionReader(String team) {
    try {
      file_reader = Match_Selection.getFileReader(team);
      MatchSelectionReader.readerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team) {
    if(MatchSelectionReader.readerCreated == false) {
      System.out.println("Calling match_reader constructor.");
      new MatchSelectionReader(team);
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    MatchSelectionReader.readerCreated = var; 
  }
}
