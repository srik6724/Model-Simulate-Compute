package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrRulesTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrRulesTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_rules.getFileWriter(team, round);
      CrossCheckPrRulesTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrRulesTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new CrossCheckPrRulesTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrRulesTeam1Writer.writerCreated = var; 
  }
}
