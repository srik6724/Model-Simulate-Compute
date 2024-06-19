package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTacticalApproachWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleTacticalApproachWriter(String team, int round) {
    try {
      file_writer = Module_Strategy.getFileWriter(team, round); 
      ModuleTacticalApproachWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleTacticalApproachWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTacticalApproachWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleTacticalApproachWriter.writerCreated = var; 
  }
}
