package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLoggerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleLoggerTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Logger.getFileWriter(team, round);
      ModuleLoggerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleLoggerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new ModuleLoggerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleLoggerTeam1Writer.writerCreated = var; 
  }
}
