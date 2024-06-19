package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrFactsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrFactsTeam2Writer(int round, String team) {
    try {
      file_writer = Module_pyreason_facts.getFileWriter(team, round);
      ModulePrFactsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrFactsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_facts constructor."); 
      new ModulePrFactsTeam1Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrFactsTeam2Writer.writerCreated = var; 
  }
}
