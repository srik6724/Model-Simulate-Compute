package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticGrammarTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckStaticGrammarTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Fixed_Grammar.getFileWriter(team, round); 
      CrossCheckStaticGrammarTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckStaticGrammarTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor."); 
      new CrossCheckStaticGrammarTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticGrammarTeam1Writer.writerCreated = var; 
  }
}
