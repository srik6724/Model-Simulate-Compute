package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrFactsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrFactsTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_facts.getFileWriter(team, round);
      MicrosecondPrFactsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrFactsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new MicrosecondPrFactsTeam1Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrFactsTeam2Writer.writerCreated = var; 
  }
}
