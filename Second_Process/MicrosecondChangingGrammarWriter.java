package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondChangingGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondChangingGrammarWriter(String team, int round) {
    try {
      file_writer = Microsecond_Dynamic_Grammar.getFileWriter(team, round);
      MicrosecondChangingGrammarWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondChangingGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new MicrosecondChangingGrammarWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondChangingGrammarWriter.writerCreated = var; 
  }
}
