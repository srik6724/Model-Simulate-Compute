package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOutputSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleOutputSpellsTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Transducer.getFileWriter(team, round); 
      ModuleOutputSpellsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleOutputSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor."); 
      new ModuleOutputSpellsTeam2Writer("t2", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleOutputSpellsTeam2Writer.writerCreated = var; 
  }

}
