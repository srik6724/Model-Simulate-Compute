package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOrderingPlacementsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckOrderingPlacementsTeam2Writer(String team, int round) {
    try { 
      file_writer = Cross_Check_Solution.getFileWriter(team, round); 
      CrossCheckOrderingPlacementsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckOrderingPlacementsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new CrossCheckOrderingPlacementsTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckOrderingPlacementsTeam2Writer.writerCreated = var; 
  }
}
