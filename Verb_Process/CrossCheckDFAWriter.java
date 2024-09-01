package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckDFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckDFAWriter(String team, int round) {
    try {
      file_writer = Cross_Check_DFA.getFileWriter(team, round);
      CrossCheckDFAWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckDFAWriter.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new CrossCheckDFAWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckDFAWriter.writerCreated = var; 
  }
}
