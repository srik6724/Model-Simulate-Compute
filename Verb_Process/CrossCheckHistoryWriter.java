package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckHistoryWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckHistoryWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Documentation.getFileWriter(team, round);
      CrossCheckHistoryWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckHistoryWriter.writerCreated == false) {
      System.out.println("Calling round_history constructor."); 
      new CrossCheckHistoryWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckHistoryWriter.writerCreated = var; 
  }
}
