package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckChangingGrammarWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckChangingGrammarWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Dynamic_Grammar.getFileWriter(team, round);
      CrossCheckChangingGrammarWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckChangingGrammarWriter.writerCreated == false) {
      System.out.println("Calling round_changing_grammar constructor."); 
      new CrossCheckChangingGrammarWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckChangingGrammarWriter.writerCreated = var; 
  }
}
