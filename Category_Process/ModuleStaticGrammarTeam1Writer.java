package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticGrammarTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleStaticGrammarTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Fixed_Grammar.getFileWriter(team, round); 
      ModuleStaticGrammarTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleStaticGrammarTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor."); 
      new ModuleStaticGrammarTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticGrammarTeam1Writer.writerCreated = var; 
  }
}
