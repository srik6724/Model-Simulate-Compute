package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleReferencePointersTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleReferencePointersTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Simulation.getFileWriter(team, round); 
      ModuleReferencePointersTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleReferencePointersTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new ModuleReferencePointersTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleReferencePointersTeam2Writer.writerCreated = var; 
  }
}
