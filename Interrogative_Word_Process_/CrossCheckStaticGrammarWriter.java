package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckStaticGrammarWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Fixed_Grammar.getFileWriter(team, round); 
      CrossCheckStaticGrammarWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckStaticGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_static_grammar constructor"); 
      new CrossCheckStaticGrammarWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticGrammarWriter.writerCreated = var; 
  }
}
