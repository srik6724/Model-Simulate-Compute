package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePathTraceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ModulePathTraceTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Induce.getFileWriter(team, round); 
      ModulePathTraceTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePathTraceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new ModulePathTraceTeam2Writer("t2", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePathTraceTeam2Writer.writerCreated = var; 
  }
}
