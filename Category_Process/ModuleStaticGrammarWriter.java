package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleStaticGrammarWriter(String team, int round) {
    try {
      file_writer = Module_Fixed_Grammar.getFileWriter(team, round); 
      ModuleStaticGrammarWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleStaticGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor"); 
      new ModuleStaticGrammarWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticGrammarWriter.writerCreated = var; 
  }
}
