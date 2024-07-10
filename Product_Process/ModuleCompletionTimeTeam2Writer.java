package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCompletionTimeTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  ModuleCompletionTimeTeam2Writer(String team, int module) {
    try {
      file_writer = Module_Duration.getFileWriter(team,  module);
      ModuleCompletionTimeTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(ModuleCompletionTimeTeam2Writer.writerCreated == false) {
      System.out.println("Calling module_completion_time constrcutor");
      new ModuleCompletionTimeTeam2Writer("t2", module);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleCompletionTimeTeam2Writer.writerCreated = var; 
  }
}
