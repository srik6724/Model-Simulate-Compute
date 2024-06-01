package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSelectionLineTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundSelectionLineTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Selection_Line_Path.getFileWriter(team, round);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundSelectionLineTeam2Writer.writerCreated == false) {
      System.out.println("Calling selection line writer constructor."); 
      new RoundSelectionLineTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundSelectionLineTeam2Writer.writerCreated = var; 
  }
}
