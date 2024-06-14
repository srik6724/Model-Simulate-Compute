package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrGraphWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrGraphWriter(int round, String team) {
    try {
      file_writer = Round_pyreason_graph.getFileWriter(team, round);
      RoundPrGraphWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrGraphWriter.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new RoundPrGraphWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrGraphWriter.writerCreated = var; 
  }
}
