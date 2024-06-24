package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePathTraceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ModulePathTraceWriter(String team, int round) {
    try {
      file_writer = Module_Induce.getFileWriter(team, round); 
      ModulePathTraceWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModulePathTraceWriter.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new ModulePathTraceWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModulePathTraceWriter.writerCreated = var; 
  }
}
