package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckDiscardSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Discarder.getFileWriter(team, round);
      CrossCheckDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  static FileWriter get_file_writer(int round) {
    if(CrossCheckDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new CrossCheckDiscardSpellsTeam2Writer(round, "t2");
    }
    return file_writer;
  }


  static void setWriterCreated(boolean var) {
    CrossCheckDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
