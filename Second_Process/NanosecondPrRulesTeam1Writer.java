package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrRulesTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrRulesTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_rules.getFileWriter(team, round);
      NanosecondPrRulesTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrRulesTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new NanosecondPrRulesTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrRulesTeam1Writer.writerCreated = var; 
  }
}
