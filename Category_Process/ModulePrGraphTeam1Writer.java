package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrGraphTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrGraphTeam1Writer(int round, String team) {
    try {
      file_writer = Module_pyreason_graph.getFileWriter(team, round);
      ModulePrGraphTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrGraphTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new ModulePrGraphTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrGraphTeam1Writer.writerCreated = var; 
  }
}
