package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrGraphTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrGraphTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_graph.getFileWriter(team, round);
      NanosecondPrGraphTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrGraphTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new NanosecondPrGraphTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrGraphTeam1Writer.writerCreated = var; 
  }
}
