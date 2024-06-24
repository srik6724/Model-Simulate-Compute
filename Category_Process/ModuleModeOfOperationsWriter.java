package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleModeOfOperationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleModeOfOperationsWriter(int round, String team) {
    try {
      file_writer = Module_Hierarchy.getFileWriter(team, round);
      ModuleModeOfOperationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleModeOfOperationsWriter.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new ModuleModeOfOperationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleModeOfOperationsWriter.writerCreated = var; 
  }
}
