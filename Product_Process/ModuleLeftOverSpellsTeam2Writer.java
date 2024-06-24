package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleLeftOverSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Remaining.getFileWriter(team, round); 
      ModuleLeftOverSpellsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleLeftOverSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new ModuleLeftOverSpellsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
  
}
