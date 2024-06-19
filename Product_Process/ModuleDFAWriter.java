package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleDFAWriter(String team, int round) {
    try {
      file_writer = Module_DFA.getFileWriter(team, round);
      ModuleDFAWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleDFAWriter.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new ModuleDFAWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleDFAWriter.writerCreated = var; 
  }
}
