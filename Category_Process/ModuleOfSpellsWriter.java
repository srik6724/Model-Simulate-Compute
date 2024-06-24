package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOfSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleOfSpellsWriter(int round, String team) {
    try {
      file_writer = Module_Recorder.getFileWriter(team, round);
      ModuleOfSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleOfSpellsWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new ModuleOfSpellsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleOfSpellsWriter.writerCreated = var; 
  }
  
}
