package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSatisfierTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundSatisfierTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Solution.getFileWriter(team, round); 
      RoundSatisfierTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundSatisfierTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new RoundSatisfierTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundSatisfierTeam1Writer.writerCreated = var; 
  }
}
