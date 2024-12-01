package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrRulesTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrRulesTeam2Writer(int round, String team) {
    try {
      file_writer = Module_pyreason_rules.getFileWriter(team, round);
      ModulePrRulesTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrRulesTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new ModulePrRulesTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrRulesTeam2Writer.writerCreated = var; 
  }
}
