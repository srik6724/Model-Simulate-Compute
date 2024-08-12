package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrRulesTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrRulesTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_rules.getFileWriter(team, round);
      NanosecondPrRulesTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrRulesTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new NanosecondPrRulesTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrRulesTeam2Writer.writerCreated = var; 
  }
}
