package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrGraphWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrGraphWriter(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_graph.getFileWriter(team, round);
      NanosecondPrGraphWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrGraphWriter.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new NanosecondPrGraphWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrGraphWriter.writerCreated = var; 
  }
}
