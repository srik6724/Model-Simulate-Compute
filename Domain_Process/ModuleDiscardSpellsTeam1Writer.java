package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleDiscardSpellsTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Discarder.getFileWriter(team, round);
      ModuleDiscardSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new ModuleDiscardSpellsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleDiscardSpellsTeam1Writer.writerCreated = var;
  }
}
