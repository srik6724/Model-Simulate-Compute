package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckStaticGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Fixed_Grammar.getFileWriter(team, round); 
      CrossCheckStaticGrammarTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckStaticGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor."); 
      new CrossCheckStaticGrammarTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticGrammarTeam2Writer.writerCreated = var; 
  }
}
