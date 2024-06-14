package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrFactsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrFactsTeam1Writer(int round, String team) {
    try {
      file_writer = Round_pyreason_facts.getFileWriter(team, round);
      RoundPrFactsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrFactsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new RoundPrFactsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrFactsTeam1Writer.writerCreated = var; 
  }
}
