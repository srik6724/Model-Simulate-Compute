package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckNFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckNFATeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_NFA.getFileWriter(team, round); 
      CrossCheckNFATeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckNFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new CrossCheckNFATeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    CrossCheckNFATeam1Writer.writerCreated = var; 
  }
}
