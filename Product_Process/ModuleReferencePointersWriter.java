package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleReferencePointersWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleReferencePointersWriter(String team, int round) {
    try {
      file_writer = Module_Simulation.getFileWriter(team, round); 
      ModuleReferencePointersWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleReferencePointersWriter.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new ModuleReferencePointersWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleReferencePointersWriter.writerCreated = var; 
  }
}
