package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundStaticGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundStaticGrammarWriter(String team, int round) {
    try {
      file_writer = Round_Fixed_Grammar.getFileWriter(team, round); 
      RoundStaticGrammarWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundStaticGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor"); 
      new RoundStaticGrammarWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundStaticGrammarWriter.writerCreated = var; 
  }
}
