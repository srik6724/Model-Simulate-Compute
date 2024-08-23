package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrFactsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrFactsTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_facts.getFileWriter(team, round);
      MicrosecondPrFactsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrFactsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new MicrosecondPrFactsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrFactsTeam1Writer.writerCreated = var; 
  }
}
