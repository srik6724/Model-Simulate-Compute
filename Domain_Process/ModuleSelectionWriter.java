package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleSelectionWriter(String team, int round) {
    try {
      file_writer = Module_Selection.getFileWriter(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleSelectionWriter.writerCreated == false) {
      System.out.println("Calling selection_line_writer constructor.");
      new ModuleSelectionWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleSelectionWriter.writerCreated = var; 
  }
}
