package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOrderingPlacementsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleOrderingPlacementsTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Permutations.getFileWriter(team, round); 
      ModuleOrderingPlacementsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleOrderingPlacementsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new ModuleOrderingPlacementsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleOrderingPlacementsTeam1Writer.writerCreated = var; 
  }
}
