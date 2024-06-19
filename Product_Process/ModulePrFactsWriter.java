package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrFactsWriter {
   private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrFactsWriter(int round, String team) {
    try {
      file_writer = Module_pyreason_facts.getFileWriter(team, round);
      ModulePrFactsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrFactsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new ModulePrFactsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrFactsWriter.writerCreated = var; 
  }
}
