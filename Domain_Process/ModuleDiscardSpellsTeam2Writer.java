package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleDiscardSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Discarder.getFileWriter(team, round);
      ModuleDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  static FileWriter get_file_writer(int round) {
    if(ModuleDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new ModuleDiscardSpellsTeam2Writer(round, "t2");
    }
    return file_writer;
  }


  static void setWriterCreated(boolean var) {
    ModuleDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
