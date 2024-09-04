package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCheckPointTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  CrossCheckCheckPointTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_State.getFileWriter(team, round);
      CrossCheckCheckPointTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckCheckPointTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new CrossCheckCheckPointTeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckCheckPointTeam2Writer.writerCreated = var; 
  }

}
