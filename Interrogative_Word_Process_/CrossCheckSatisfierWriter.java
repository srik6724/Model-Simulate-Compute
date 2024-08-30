package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckSatisfierWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckSatisfierWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Solution.getFileWriter(team, round); 
      CrossCheckSatisfierWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckSatisfierWriter.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new CrossCheckSatisfierWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckSatisfierWriter.writerCreated = var; 
  }
}
