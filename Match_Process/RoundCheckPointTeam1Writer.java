package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundCheckPointTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  RoundCheckPointTeam1Writer(String team, int round) {
    try {
      file_writer = Round_State.getFileWriter(team, round);
      RoundCheckPointTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundCheckPointTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new RoundCheckPointTeam1Writer("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundCheckPointTeam1Writer.writerCreated = var; 
  }
}
