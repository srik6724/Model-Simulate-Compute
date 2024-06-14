package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrFactsWriter {
   private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrFactsWriter(int round, String team) {
    try {
      file_writer = Round_pyreason_facts.getFileWriter(team, round);
      RoundPrFactsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrFactsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new RoundPrFactsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrFactsWriter.writerCreated = var; 
  }
}
