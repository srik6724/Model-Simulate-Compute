package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrFactsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrFactsTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_facts.getFileWriter(team, round);
      NanosecondPrFactsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrFactsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new NanosecondPrFactsTeam1Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrFactsTeam2Writer.writerCreated = var; 
  }
}
