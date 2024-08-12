package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondChangingGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondChangingGrammarWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Dynamic_Grammar.getFileWriter(team, round);
      NanosecondChangingGrammarWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondChangingGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new NanosecondChangingGrammarWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondChangingGrammarWriter.writerCreated = var; 
  }
}
