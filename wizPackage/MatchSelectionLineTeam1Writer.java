package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class MatchSelectionLineTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  MatchSelectionLineTeam1Writer(String team) {
    try {
      file_writer = Match_Selection_Line_Path.getFileWriter(team); 
      MatchSelectionLineTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static FileWriter get_file_writer() {
    if(MatchSelectionLineTeam1Writer.writerCreated == false) {
      System.out.println("Calling match_selection constructor."); 
      new MatchSelectionLineTeam1Writer("t1");
    } 
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchSelectionLineTeam1Writer.writerCreated = var;
  }
  
}
