package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrRulesWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrRulesWriter(int round, String team) {
    try {
      file_writer = Module_pyreason_rules.getFileWriter(team, round);
      ModulePrRulesWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrRulesWriter.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new ModulePrRulesWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrRulesWriter.writerCreated = var; 
  }
}
