package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrGraphTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrGraphTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_graph.getFileWriter(team, round);
      CrossCheckPrGraphTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrGraphTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new CrossCheckPrGraphTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrGraphTeam2Writer.writerCreated = var; 
  }
}
