package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleRunTimeTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleRunTimeTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Process.getFileWriter(team, round); 
      ModuleRunTimeTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleRunTimeTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new ModuleRunTimeTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleRunTimeTeam2Writer.writerCreated = var; 
  }
}
