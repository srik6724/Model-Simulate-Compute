package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundTacticalApproachTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundTacticalApproachTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Strategy.getFileWriter(team, round); 
      RoundTacticalApproachTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundTacticalApproachTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundTacticalApproachTeam2Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundTacticalApproachTeam2Writer.writerCreated = var; 
  }
}
