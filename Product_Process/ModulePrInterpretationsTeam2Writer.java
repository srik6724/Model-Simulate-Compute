package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrInterpretationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrInterpretationsTeam2Writer(int round, String team) {
    try {
      file_writer = Module_pyreason_interpretations.getFileWriter(team, round);
      ModulePrInterpretationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrInterpretationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new ModulePrInterpretationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrInterpretationsTeam2Writer.writerCreated = var; 
  }
}
