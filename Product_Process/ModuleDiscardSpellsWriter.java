package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleDiscardSpellsWriter(int round, String team) {
    try {
      file_writer = Module_Discarder.getFileWriter(team, round); 
      ModuleDiscardSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new ModuleDiscardSpellsWriter(round, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    ModuleDiscardSpellsWriter.writerCreated = var; 
  }
}
