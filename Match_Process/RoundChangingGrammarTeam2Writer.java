package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundChangingGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundChangingGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Dynamic_Grammar.getFileWriter(team, round);
      RoundChangingGrammarTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundChangingGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new RoundChangingGrammarTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundChangingGrammarTeam2Writer.writerCreated = var; 
  }
}
