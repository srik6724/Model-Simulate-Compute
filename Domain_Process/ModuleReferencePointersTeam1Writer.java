package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleReferencePointersTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleReferencePointersTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Simulation.getFileWriter(team, round); 
      ModuleReferencePointersTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleReferencePointersTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new ModuleReferencePointersTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleReferencePointersTeam1Writer.writerCreated = var; 
  }
}
