package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTeam2SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleTeam2SpellsWriter(String team, int round) {
    try {
      file_writer = Module_Recorder.getFileWriter(team, round);
      ModuleTeam2SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleTeam2SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new ModuleTeam2SpellsWriter("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleTeam2SpellsWriter.writerCreated = var; 
  }
  
}
