package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleHistoryTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleHistoryTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Documentation.getFileWriter(team, round);
      ModuleHistoryTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleHistoryTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new ModuleHistoryTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleHistoryTeam2Writer.writerCreated = var; 
  }
}
