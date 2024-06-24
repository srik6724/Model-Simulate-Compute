package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOutputSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ModuleOutputSpellsWriter(String team, int round) {
    try {
      file_writer = Module_Transducer.getFileWriter(team, round); 
      ModuleOutputSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleOutputSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new ModuleOutputSpellsWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleOutputSpellsWriter.writerCreated = var; 
  }
}
