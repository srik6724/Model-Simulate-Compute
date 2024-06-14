package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundCheckPointTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  RoundCheckPointTeam2Writer(String team, int round) {
    try {
      file_writer = Round_State.getFileWriter(team, round);
      RoundCheckPointTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundCheckPointTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new RoundCheckPointTeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundCheckPointTeam2Writer.writerCreated = var; 
  }

}
