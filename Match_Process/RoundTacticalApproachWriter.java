package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundTacticalApproachWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundTacticalApproachWriter(String team, int round) {
    try {
      file_writer = Round_Strategy.getFileWriter(team, round); 
      RoundTacticalApproachWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundTacticalApproachWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundTacticalApproachWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundTacticalApproachWriter.writerCreated = var; 
  }
}
