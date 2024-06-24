package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleGenerationTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleGenerationTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Generation.getFileWriter(team, round);
      ModuleGenerationTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleGenerationTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_generation constructor.");
      new ModuleGenerationTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleGenerationTeam1Writer.writerCreated = var;
  }

}
