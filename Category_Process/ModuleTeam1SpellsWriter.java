package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTeam1SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleTeam1SpellsWriter(String team, int round) {
    try {
      file_writer = Module_Recorder.getFileWriter(team, round); 
      ModuleTeam1SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleTeam1SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTeam1SpellsWriter("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleTeam1SpellsWriter.writerCreated = var; 
  }
}
