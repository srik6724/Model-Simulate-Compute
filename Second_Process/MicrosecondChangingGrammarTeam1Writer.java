package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondChangingGrammarTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondChangingGrammarTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Dynamic_Grammar.getFileWriter(team, round);
      MicrosecondChangingGrammarTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondChangingGrammarTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new MicrosecondChangingGrammarTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondChangingGrammarTeam1Writer.writerCreated = var; 
  }
}
