package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleSatisfierWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleSatisfierWriter(String team, int round) {
    try {
      file_writer = Module_Solution.getFileWriter(team, round); 
      ModuleSatisfierWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleSatisfierWriter.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new ModuleSatisfierWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleSatisfierWriter.writerCreated = var; 
  }
}
