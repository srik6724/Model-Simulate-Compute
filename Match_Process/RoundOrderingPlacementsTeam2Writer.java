package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOrderingPlacementsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundOrderingPlacementsTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Solution.getFileWriter(team, round); 
      RoundOrderingPlacementsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundOrderingPlacementsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new RoundOrderingPlacementsTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundOrderingPlacementsTeam2Writer.writerCreated = var; 
  }
}
