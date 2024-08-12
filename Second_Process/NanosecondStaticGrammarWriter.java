package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondStaticGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondStaticGrammarWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Fixed_Grammar.getFileWriter(team, round); 
      NanosecondStaticGrammarWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondStaticGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor"); 
      new NanosecondStaticGrammarWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondStaticGrammarWriter.writerCreated = var; 
  }
}
