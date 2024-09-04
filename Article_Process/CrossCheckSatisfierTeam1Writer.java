package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckSatisfierTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckSatisfierTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Solution.getFileWriter(team, round); 
      CrossCheckSatisfierTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckSatisfierTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new CrossCheckSatisfierTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckSatisfierTeam1Writer.writerCreated = var; 
  }
}
