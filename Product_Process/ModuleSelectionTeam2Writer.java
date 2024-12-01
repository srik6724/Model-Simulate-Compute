package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleSelectionTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Selection.getFileWriter(team, round);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleSelectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling selection line writer constructor."); 
      new ModuleSelectionTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleSelectionTeam2Writer.writerCreated = var; 
  }
}
