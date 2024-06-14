package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundStaticGrammarTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundStaticGrammarTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Fixed_Grammar.getFileWriter(team, round); 
      RoundStaticGrammarTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundStaticGrammarTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor."); 
      new RoundStaticGrammarTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundStaticGrammarTeam1Writer.writerCreated = var; 
  }
}
