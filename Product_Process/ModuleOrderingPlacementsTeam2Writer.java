package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOrderingPlacementsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleOrderingPlacementsTeam2Writer(String team, int round) {
    try { 
      file_writer = Module_Solution.getFileWriter(team, round); 
      ModuleOrderingPlacementsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleOrderingPlacementsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new ModuleOrderingPlacementsTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleOrderingPlacementsTeam2Writer.writerCreated = var; 
  }
}
