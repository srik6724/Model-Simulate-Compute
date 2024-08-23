package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondStaticGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondStaticGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Fixed_Grammar.getFileWriter(team, round); 
      MicrosecondStaticGrammarTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondStaticGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor."); 
      new MicrosecondStaticGrammarTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondStaticGrammarTeam2Writer.writerCreated = var; 
  }
}
