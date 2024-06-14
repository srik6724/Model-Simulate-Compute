package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrGraphTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrGraphTeam2Writer(int round, String team) {
    try {
      file_writer = Round_pyreason_graph.getFileWriter(team, round);
      RoundPrGraphTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrGraphTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new RoundPrGraphTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrGraphTeam2Writer.writerCreated = var; 
  }
}
