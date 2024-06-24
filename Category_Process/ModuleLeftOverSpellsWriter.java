package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleLeftOverSpellsWriter(int round, String team) {
    try {
      file_writer = Module_Remaining.getFileWriter(team, round); 
      ModuleLeftOverSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new ModuleLeftOverSpellsWriter(round, "default"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    ModuleLeftOverSpellsWriter.writerCreated = var; 
  }
}
