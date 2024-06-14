package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSatisfierTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundSatisfierTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Solution.getFileWriter(team, round); 
      RoundSatisfierTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundSatisfierTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new RoundSatisfierTeam1Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundSatisfierTeam2Writer.writerCreated = var; 
  }
}
