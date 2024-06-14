package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrRulesWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrRulesWriter(int round, String team) {
    try {
      file_writer = Round_pyreason_rules.getFileWriter(team, round);
      RoundPrRulesWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrRulesWriter.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new RoundPrRulesWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrRulesWriter.writerCreated = var; 
  }
}
