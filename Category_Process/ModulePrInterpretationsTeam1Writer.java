package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrInterpretationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrInterpretationsTeam1Writer(int round, String team) {
    try {
      file_writer = Module_pyreason_interpretations.getFileWriter(team, round);
      ModulePrInterpretationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrInterpretationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new ModulePrInterpretationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrInterpretationsTeam1Writer.writerCreated = var; 
  }
}
