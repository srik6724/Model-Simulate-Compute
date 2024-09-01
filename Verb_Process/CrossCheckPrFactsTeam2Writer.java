package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrFactsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrFactsTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_facts.getFileWriter(team, round);
      CrossCheckPrFactsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrFactsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new CrossCheckPrFactsTeam1Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrFactsTeam2Writer.writerCreated = var; 
  }
}
