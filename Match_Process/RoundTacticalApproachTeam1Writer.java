package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundTacticalApproachTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundTacticalApproachTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Strategy.getFileWriter(team, round); 
      RoundTacticalApproachTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundTacticalApproachTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundTacticalApproachTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundTacticalApproachTeam1Writer.writerCreated = var; 
  }
}
