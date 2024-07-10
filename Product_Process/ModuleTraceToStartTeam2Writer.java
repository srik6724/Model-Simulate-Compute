package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTraceToStartTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleTraceToStartTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Backtrack.getFileWriter(team, round); 
      ModuleTraceToStartTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleTraceToStartTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTraceToStartTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleTraceToStartTeam2Writer.writerCreated = var; 
  }
}
