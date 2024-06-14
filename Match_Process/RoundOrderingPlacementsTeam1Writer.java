package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOrderingPlacementsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundOrderingPlacementsTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Permutations.getFileWriter(team, round); 
      RoundOrderingPlacementsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundOrderingPlacementsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new RoundOrderingPlacementsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundOrderingPlacementsTeam1Writer.writerCreated = var; 
  }
}
