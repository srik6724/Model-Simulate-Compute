package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondStaticGrammarTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondStaticGrammarTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Fixed_Grammar.getFileWriter(team, round); 
      NanosecondStaticGrammarTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondStaticGrammarTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor."); 
      new NanosecondStaticGrammarTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondStaticGrammarTeam2Writer.writerCreated = var; 
  }
}
