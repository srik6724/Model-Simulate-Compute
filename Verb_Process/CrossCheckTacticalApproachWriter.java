package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTacticalApproachWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckTacticalApproachWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Strategy.getFileWriter(team, round); 
      CrossCheckTacticalApproachWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckTacticalApproachWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTacticalApproachWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTacticalApproachWriter.writerCreated = var; 
  }
}
