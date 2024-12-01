package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleRunTimeWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleRunTimeWriter(String team, int round) {
    try {
      file_writer = Module_Process.getFileWriter(team, round); 
      ModuleRunTimeWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleRunTimeWriter.writerCreated == false) {
      System.out.println("Calling round_run_time constructor"); 
      new ModuleRunTimeWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleRunTimeWriter.writerCreated = var; 
  }
}
