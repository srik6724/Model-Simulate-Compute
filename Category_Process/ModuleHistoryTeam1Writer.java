package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleHistoryTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleHistoryTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Documentation.getFileWriter(team, round);
      ModuleHistoryTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleHistoryTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new ModuleHistoryTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleHistoryTeam1Writer.writerCreated = var; 
  }
}
