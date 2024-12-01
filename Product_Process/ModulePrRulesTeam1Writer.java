package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrRulesTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrRulesTeam1Writer(int round, String team) {
    try {
      file_writer = Module_pyreason_rules.getFileWriter(team, round);
      ModulePrRulesTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrRulesTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor."); 
      new ModulePrRulesTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrRulesTeam1Writer.writerCreated = var; 
  }
}
