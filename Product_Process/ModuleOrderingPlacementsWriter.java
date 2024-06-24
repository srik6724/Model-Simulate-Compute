package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOrderingPlacementsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleOrderingPlacementsWriter(String team, int round) {
    try {
      file_writer = Module_Permutations.getFileWriter(team, round); 
      ModuleOrderingPlacementsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleOrderingPlacementsWriter.writerCreated == false) {
      System.out.println("Calling round_ordering_placements constructor"); 
      new ModuleOrderingPlacementsWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) { 
    ModuleOrderingPlacementsWriter.writerCreated = var; 
  }
}
