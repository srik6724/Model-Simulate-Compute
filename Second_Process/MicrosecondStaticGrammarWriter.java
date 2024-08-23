package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondStaticGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondStaticGrammarWriter(String team, int round) {
    try {
      file_writer = Microsecond_Fixed_Grammar.getFileWriter(team, round); 
      MicrosecondStaticGrammarWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondStaticGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor"); 
      new MicrosecondStaticGrammarWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondStaticGrammarWriter.writerCreated = var; 
  }
}
