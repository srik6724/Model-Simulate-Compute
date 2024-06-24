package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleChangingGrammarTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleChangingGrammarTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Dynamic_Grammar.getFileWriter(team, round);
      ModuleChangingGrammarTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleChangingGrammarTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new ModuleChangingGrammarTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleChangingGrammarTeam1Writer.writerCreated = var; 
  }
}
