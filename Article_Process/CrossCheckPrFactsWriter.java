package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrFactsWriter {
   private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrFactsWriter(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_facts.getFileWriter(team, round);
      CrossCheckPrFactsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrFactsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new CrossCheckPrFactsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrFactsWriter.writerCreated = var; 
  }
}
