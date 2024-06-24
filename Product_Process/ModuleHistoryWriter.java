package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleHistoryWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleHistoryWriter(int round, String team) {
    try {
      file_writer = Module_Documentation.getFileWriter(team, round);
      ModuleHistoryWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleHistoryWriter.writerCreated == false) {
      System.out.println("Calling round_history constructor."); 
      new ModuleHistoryWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleHistoryWriter.writerCreated = var; 
  }
}
