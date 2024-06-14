package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundChangingGrammarTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundChangingGrammarTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Dynamic_Grammar.getFileWriter(team, round);
      RoundChangingGrammarTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundChangingGrammarTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new RoundChangingGrammarTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundChangingGrammarTeam1Writer.writerCreated = var; 
  }
}
