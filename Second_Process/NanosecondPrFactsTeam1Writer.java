package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrFactsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrFactsTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_facts.getFileWriter(team, round);
      NanosecondPrFactsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrFactsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new NanosecondPrFactsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrFactsTeam1Writer.writerCreated = var; 
  }
}
