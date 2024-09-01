package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckSelectionTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Selection.getFileWriter(team, round);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckSelectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling selection line writer constructor."); 
      new CrossCheckSelectionTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckSelectionTeam2Writer.writerCreated = var; 
  }
}
