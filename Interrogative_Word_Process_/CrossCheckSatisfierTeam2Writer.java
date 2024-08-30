package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckSatisfierTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckSatisfierTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Solution.getFileWriter(team, round); 
      CrossCheckSatisfierTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckSatisfierTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new CrossCheckSatisfierTeam1Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckSatisfierTeam2Writer.writerCreated = var; 
  }
}
