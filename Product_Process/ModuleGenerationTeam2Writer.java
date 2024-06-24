package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleGenerationTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleGenerationTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Generation.getFileWriter(team, round);
      ModuleGenerationTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleGenerationTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_generation constructor.");
      new ModuleGenerationTeam2Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleGenerationTeam2Writer.writerCreated = var;
  }
}
