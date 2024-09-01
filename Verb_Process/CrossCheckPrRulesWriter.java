package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrRulesWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrRulesWriter(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_rules.getFileWriter(team, round);
      CrossCheckPrRulesWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrRulesWriter.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new CrossCheckPrRulesWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrRulesWriter.writerCreated = var; 
  }
}
