package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLoggerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleLoggerWriter(int round, String team) {
    try {
      file_writer = Module_Logger.getFileWriter(team, round);
      ModuleLoggerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleLoggerWriter.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new ModuleLoggerWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleLoggerWriter.writerCreated = var; 
  }
}
