package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleGenerationWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ModuleGenerationWriter(int round, String team) {
    try {
      file_writer = Module_Generation.getFileWriter(team, round);
      ModuleGenerationWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleGenerationWriter.writerCreated == false) {
      System.out.println("Calling round_generation constructor."); 
      new ModuleGenerationWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleGenerationWriter.writerCreated = var; 
  }
}
