package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class MatchSelectionTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  MatchSelectionTeam1Writer(String team) {
    try {
      file_writer = Match_Selection.getFileWriter(team); 
      MatchSelectionTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static FileWriter get_file_writer() {
    if(MatchSelectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling match_selection constructor."); 
      new MatchSelectionTeam1Writer("t1");
    } 
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchSelectionTeam1Writer.writerCreated = var;
  }
  
}
