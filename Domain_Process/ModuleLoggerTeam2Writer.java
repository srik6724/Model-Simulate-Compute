package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLoggerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleLoggerTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Logger.getFileWriter(team, round);
      ModuleLoggerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleLoggerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new ModuleLoggerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleLoggerTeam2Writer.writerCreated = var; 
  }
}
