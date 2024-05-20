package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundLeftOverSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Remaining.getFileWriter(team, round); 
      RoundLeftOverSpellsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundLeftOverSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new RoundLeftOverSpellsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }
  
}
