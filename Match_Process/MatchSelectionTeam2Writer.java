package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class MatchSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MatchSelectionTeam2Writer(String team) {
    try {
      file_writer = Match_Selection.getFileWriter(team); 
      MatchSelectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchSelectionTeam2Writer.writerCreated == true) {
      System.out.println("Calling match_selection constructor."); 
      new MatchSelectionTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchSelectionTeam2Writer.writerCreated = var; 
  }
}
