package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrGraphTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrGraphTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_graph.getFileWriter(team, round);
      MicrosecondPrGraphTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrGraphTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new MicrosecondPrGraphTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrGraphTeam2Writer.writerCreated = var; 
  }
}
