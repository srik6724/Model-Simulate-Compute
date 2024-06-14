package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundStaticGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundStaticGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Fixed_Grammar.getFileWriter(team, round); 
      RoundStaticGrammarTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundStaticGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor."); 
      new RoundStaticGrammarTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundStaticGrammarTeam2Writer.writerCreated = var; 
  }
}
