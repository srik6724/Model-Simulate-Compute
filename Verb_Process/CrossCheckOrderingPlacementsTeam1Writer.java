package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOrderingPlacementsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckOrderingPlacementsTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Permutations.getFileWriter(team, round); 
      CrossCheckOrderingPlacementsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckOrderingPlacementsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new CrossCheckOrderingPlacementsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckOrderingPlacementsTeam1Writer.writerCreated = var; 
  }
}
