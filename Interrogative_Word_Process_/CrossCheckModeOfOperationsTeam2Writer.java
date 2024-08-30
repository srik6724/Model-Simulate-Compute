package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckModeOfOperationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckModeOfOperationsTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Hierarchy.getFileWriter(team, round);
      CrossCheckModeOfOperationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckModeOfOperationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new CrossCheckModeOfOperationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckModeOfOperationsTeam2Writer.writerCreated = var; 
  }
}
