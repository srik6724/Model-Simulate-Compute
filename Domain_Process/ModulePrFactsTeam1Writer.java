package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrFactsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrFactsTeam1Writer(int round, String team) {
    try {
      file_writer = Module_pyreason_facts.getFileWriter(team, round);
      ModulePrFactsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrFactsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new ModulePrFactsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrFactsTeam1Writer.writerCreated = var; 
  }
}
