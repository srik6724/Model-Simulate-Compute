package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTraceToStartWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleTraceToStartWriter(String team, int round) {
    try {
      file_writer = Module_Backtrack.getFileWriter(team, round); 
      ModuleTraceToStartWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleTraceToStartWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTraceToStartWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleTraceToStartWriter.writerCreated = var; 
  }
}
