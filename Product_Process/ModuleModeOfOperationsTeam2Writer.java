package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleModeOfOperationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleModeOfOperationsTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Hierarchy.getFileWriter(team, round);
      ModuleModeOfOperationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleModeOfOperationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new ModuleModeOfOperationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleModeOfOperationsTeam2Writer.writerCreated = var; 
  }
}
