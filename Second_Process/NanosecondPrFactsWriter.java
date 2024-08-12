package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrFactsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrFactsWriter(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_facts.getFileWriter(team, round);
      NanosecondPrFactsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrFactsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new NanosecondPrFactsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrFactsWriter.writerCreated = var; 
  }
}
