package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePathTraceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ModulePathTraceTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Induce.getFileWriter(team, round); 
      ModulePathTraceTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePathTraceTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new ModulePathTraceTeam1Writer("t1", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePathTraceTeam1Writer.writerCreated = var; 
  }
}
