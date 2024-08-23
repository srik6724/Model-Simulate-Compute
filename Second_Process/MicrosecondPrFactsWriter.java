package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrFactsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrFactsWriter(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_facts.getFileWriter(team, round);
      MicrosecondPrFactsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrFactsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new MicrosecondPrFactsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrFactsWriter.writerCreated = var; 
  }
}
