package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrRulesTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrRulesTeam1Writer(int round, String team) {
    try {
      file_writer = Round_pyreason_rules.getFileWriter(team, round);
      RoundPrRulesTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrRulesTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new RoundPrRulesTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrRulesTeam1Writer.writerCreated = var; 
  }
}
