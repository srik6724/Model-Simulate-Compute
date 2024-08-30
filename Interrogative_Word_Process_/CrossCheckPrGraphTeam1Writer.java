package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrGraphTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrGraphTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_graph.getFileWriter(team, round);
      CrossCheckPrGraphTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrGraphTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new CrossCheckPrGraphTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrGraphTeam1Writer.writerCreated = var; 
  }
}
