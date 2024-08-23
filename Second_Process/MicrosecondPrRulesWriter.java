package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrRulesWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrRulesWriter(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_rules.getFileWriter(team, round);
      MicrosecondPrRulesWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrRulesWriter.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new MicrosecondPrRulesWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrRulesWriter.writerCreated = var; 
  }
}
