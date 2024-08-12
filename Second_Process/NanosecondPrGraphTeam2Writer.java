package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrGraphTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrGraphTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_graph.getFileWriter(team, round);
      NanosecondPrGraphTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrGraphTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new NanosecondPrGraphTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrGraphTeam2Writer.writerCreated = var; 
  }
}
