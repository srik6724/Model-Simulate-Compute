package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundLeftOverSpellsTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Remaining.getFileWriter(team, round);
      RoundLeftOverSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new RoundLeftOverSpellsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }
  
}
