package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrRulesTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrRulesTeam2Writer(int round, String team) {
    try {
      file_writer = Round_pyreason_rules.getFileWriter(team, round);
      RoundPrRulesTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrRulesTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new RoundPrRulesTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrRulesTeam2Writer.writerCreated = var; 
  }
}
