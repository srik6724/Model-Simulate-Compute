package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleRunTimeTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleRunTimeTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Process.getFileWriter(team, round); 
      ModuleRunTimeTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleRunTimeTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new ModuleRunTimeTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleRunTimeTeam1Writer.writerCreated = var; 
  }
}
