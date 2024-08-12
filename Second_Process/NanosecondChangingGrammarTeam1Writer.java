package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondChangingGrammarTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondChangingGrammarTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Dynamic_Grammar.getFileWriter(team, round);
      NanosecondChangingGrammarTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondChangingGrammarTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new NanosecondChangingGrammarTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondChangingGrammarTeam1Writer.writerCreated = var; 
  }
}
