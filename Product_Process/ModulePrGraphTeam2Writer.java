package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrGraphTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrGraphTeam2Writer(int round, String team) {
    try {
      file_writer = Module_pyreason_graph.getFileWriter(team, round);
      ModulePrGraphTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrGraphTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new ModulePrGraphTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrGraphTeam2Writer.writerCreated = var; 
  }
}
