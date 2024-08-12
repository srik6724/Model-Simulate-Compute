package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondStaticGrammarTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondStaticGrammarTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Fixed_Grammar.getFileWriter(team, round); 
      NanosecondStaticGrammarTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondStaticGrammarTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor."); 
      new NanosecondStaticGrammarTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondStaticGrammarTeam1Writer.writerCreated = var; 
  }
}
