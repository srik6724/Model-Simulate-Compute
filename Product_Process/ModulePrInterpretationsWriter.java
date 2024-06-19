package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrInterpretationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModulePrInterpretationsWriter(int round, String team) {
    try {
      file_writer = Module_pyreason_interpretations.getFileWriter(team, round);
      ModulePrInterpretationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePrInterpretationsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new ModulePrInterpretationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePrInterpretationsWriter.writerCreated = var; 
  }
}
