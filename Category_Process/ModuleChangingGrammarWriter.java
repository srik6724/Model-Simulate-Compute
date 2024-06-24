package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleChangingGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleChangingGrammarWriter(String team, int round) {
    try {
      file_writer = Module_Dynamic_Grammar.getFileWriter(team, round);
      ModuleChangingGrammarWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleChangingGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new ModuleChangingGrammarWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleChangingGrammarWriter.writerCreated = var; 
  }
}
