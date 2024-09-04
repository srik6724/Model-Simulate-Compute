package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTacticalApproachTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckTacticalApproachTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Strategy.getFileWriter(team, round); 
      CrossCheckTacticalApproachTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckTacticalApproachTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTacticalApproachTeam2Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTacticalApproachTeam2Writer.writerCreated = var; 
  }
}
