package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundDiscardSpellsTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Discarder.getFileWriter(team, round);
      RoundDiscardSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new RoundDiscardSpellsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundDiscardSpellsTeam1Writer.writerCreated = var;
  }
}
