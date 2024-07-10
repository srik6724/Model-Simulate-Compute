package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCompletionTimeWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  ModuleCompletionTimeWriter(String team, int module) {
    try {
      file_writer = Module_Duration.getFileWriter(team,  module);
      ModuleCompletionTimeWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(ModuleCompletionTimeWriter.writerCreated == false) {
      System.out.println("Calling module_completion_time constrcutor");
      new ModuleCompletionTimeWriter("default", module); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleCompletionTimeWriter.writerCreated = var; 
  }
}
