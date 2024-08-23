package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrRulesTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrRulesTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_rules.getFileWriter(team, round);
      MicrosecondPrRulesTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrRulesTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new MicrosecondPrRulesTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrRulesTeam1Writer.writerCreated = var; 
  }
}
