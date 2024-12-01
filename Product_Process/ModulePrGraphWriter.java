package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrGraphWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrGraphWriter(int round, String team) {
    try {
      file_writer = Module_pyreason_graph.getFileWriter(team, round);
      ModulePrGraphWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrGraphWriter.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new ModulePrGraphWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrGraphWriter.writerCreated = var; 
  }
}
