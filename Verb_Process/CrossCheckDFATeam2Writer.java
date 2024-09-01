package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckDFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckDFATeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_DFA.getFileWriter(team, round);
      CrossCheckDFATeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckDFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new CrossCheckDFATeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    CrossCheckDFATeam2Writer.writerCreated = var; 
  }
}
