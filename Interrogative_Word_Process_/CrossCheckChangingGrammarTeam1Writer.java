package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckChangingGrammarTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckChangingGrammarTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Dynamic_Grammar.getFileWriter(team, round);
      CrossCheckChangingGrammarTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckChangingGrammarTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new CrossCheckChangingGrammarTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckChangingGrammarTeam1Writer.writerCreated = var; 
  }
}
