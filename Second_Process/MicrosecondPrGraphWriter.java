package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrGraphWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrGraphWriter(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_graph.getFileWriter(team, round);
      MicrosecondPrGraphWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrGraphWriter.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new MicrosecondPrGraphWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrGraphWriter.writerCreated = var; 
  }
}
