package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrRulesTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrRulesTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_rules.getFileWriter(team, round);
      CrossCheckPrRulesTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrRulesTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new CrossCheckPrRulesTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrRulesTeam2Writer.writerCreated = var; 
  }
}
