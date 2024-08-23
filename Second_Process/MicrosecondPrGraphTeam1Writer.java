package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrGraphTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrGraphTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_graph.getFileWriter(team, round);
      MicrosecondPrGraphTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrGraphTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new MicrosecondPrGraphTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrGraphTeam1Writer.writerCreated = var; 
  }
}
