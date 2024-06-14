package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundChangingGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundChangingGrammarWriter(String team, int round) {
    try {
      file_writer = Round_Dynamic_Grammar.getFileWriter(team, round);
      RoundChangingGrammarWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundChangingGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new RoundChangingGrammarWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundChangingGrammarWriter.writerCreated = var; 
  }
}
