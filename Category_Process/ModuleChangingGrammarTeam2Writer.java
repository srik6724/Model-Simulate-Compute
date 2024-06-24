package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleChangingGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleChangingGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Dynamic_Grammar.getFileWriter(team, round);
      ModuleChangingGrammarTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleChangingGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new ModuleChangingGrammarTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleChangingGrammarTeam2Writer.writerCreated = var; 
  }
}
