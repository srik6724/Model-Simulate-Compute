package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckDFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckDFATeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_DFA.getFileWriter(team, round);
      CrossCheckDFATeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckDFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new CrossCheckDFATeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    CrossCheckDFATeam1Writer.writerCreated = var; 
  }
}
