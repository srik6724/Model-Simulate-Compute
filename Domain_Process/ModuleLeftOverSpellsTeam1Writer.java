package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleLeftOverSpellsTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Remaining.getFileWriter(team, round);
      ModuleLeftOverSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new ModuleLeftOverSpellsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
  
}
