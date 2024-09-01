package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckModeOfOperationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckModeOfOperationsWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Hierarchy.getFileWriter(team, round);
      CrossCheckModeOfOperationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckModeOfOperationsWriter.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new CrossCheckModeOfOperationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckModeOfOperationsWriter.writerCreated = var; 
  }
}
