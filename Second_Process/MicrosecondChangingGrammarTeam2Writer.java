package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondChangingGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondChangingGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Dynamic_Grammar.getFileWriter(team, round);
      MicrosecondChangingGrammarTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondChangingGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new MicrosecondChangingGrammarTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondChangingGrammarTeam2Writer.writerCreated = var; 
  }
}
