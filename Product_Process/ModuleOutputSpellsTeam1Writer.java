package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOutputSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleOutputSpellsTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Transducer.getFileWriter(team, round); 
      ModuleOutputSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleOutputSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new ModuleOutputSpellsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleOutputSpellsTeam1Writer.writerCreated = var; 
  }
}
