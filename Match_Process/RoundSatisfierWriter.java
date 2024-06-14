package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSatisfierWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundSatisfierWriter(String team, int round) {
    try {
      file_writer = Round_Solution.getFileWriter(team, round); 
      RoundSatisfierWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundSatisfierWriter.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new RoundSatisfierWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundSatisfierWriter.writerCreated = var; 
  }
}
