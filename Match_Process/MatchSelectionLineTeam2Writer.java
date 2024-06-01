package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class MatchSelectionLineTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MatchSelectionLineTeam2Writer(String team) {
    try {
      file_writer = Match_Selection_Line_Path.getFileWriter(team); 
      MatchSelectionLineTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchSelectionLineTeam2Writer.writerCreated == true) {
      System.out.println("Calling match_selection constructor."); 
      new MatchSelectionLineTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchSelectionLineTeam2Writer.writerCreated = var; 
  }
}
