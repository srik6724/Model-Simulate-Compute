package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckChangingGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckChangingGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Dynamic_Grammar.getFileWriter(team, round);
      CrossCheckChangingGrammarTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckChangingGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new CrossCheckChangingGrammarTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckChangingGrammarTeam2Writer.writerCreated = var; 
  }
}
