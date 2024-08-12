package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondChangingGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondChangingGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Dynamic_Grammar.getFileWriter(team, round);
      NanosecondChangingGrammarTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondChangingGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new NanosecondChangingGrammarTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondChangingGrammarTeam2Writer.writerCreated = var; 
  }
}
