package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleModeOfOperationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleModeOfOperationsTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Hierarchy.getFileWriter(team, round);
      ModuleModeOfOperationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleModeOfOperationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new ModuleModeOfOperationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleModeOfOperationsTeam1Writer.writerCreated = var; 
  }
}
