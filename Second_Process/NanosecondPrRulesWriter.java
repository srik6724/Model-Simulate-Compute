package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrRulesWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrRulesWriter(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_rules.getFileWriter(team, round);
      NanosecondPrRulesWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrRulesWriter.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new NanosecondPrRulesWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrRulesWriter.writerCreated = var; 
  }
}
