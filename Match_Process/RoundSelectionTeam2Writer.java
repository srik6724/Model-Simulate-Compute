package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundSelectionTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Selection.getFileWriter(team, round);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundSelectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling selection line writer constructor."); 
      new RoundSelectionTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundSelectionTeam2Writer.writerCreated = var; 
  }
}
