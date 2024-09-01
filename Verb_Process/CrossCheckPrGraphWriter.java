package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrGraphWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrGraphWriter(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_graph.getFileWriter(team, round);
      CrossCheckPrGraphWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrGraphWriter.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new CrossCheckPrGraphWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrGraphWriter.writerCreated = var; 
  }
}
