package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundDiscardSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Discarder.getFileWriter(team, round);
      RoundDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  static FileWriter get_file_writer(int round) {
    if(RoundDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new RoundDiscardSpellsTeam2Writer(round, "t2");
    }
    return file_writer;
  }
}
