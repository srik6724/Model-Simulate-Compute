package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTraceToStartTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleTraceToStartTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Backtrack.getFileWriter(team, round); 
      ModuleTraceToStartTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleTraceToStartTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTraceToStartTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleTraceToStartTeam1Writer.writerCreated = var; 
  }
}
