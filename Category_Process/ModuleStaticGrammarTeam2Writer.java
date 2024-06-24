package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleStaticGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Fixed_Grammar.getFileWriter(team, round); 
      ModuleStaticGrammarTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleStaticGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor."); 
      new ModuleStaticGrammarTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticGrammarTeam2Writer.writerCreated = var; 
  }
}
