package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckHistoryTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckHistoryTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Documentation.getFileWriter(team, round);
      CrossCheckHistoryTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckHistoryTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new CrossCheckHistoryTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckHistoryTeam2Writer.writerCreated = var; 
  }
}
