package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrFactsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrFactsTeam2Writer(int round, String team) {
    try {
      file_writer = Round_pyreason_facts.getFileWriter(team, round);
      RoundPrFactsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrFactsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new RoundPrFactsTeam1Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrFactsTeam2Writer.writerCreated = var; 
  }
}
