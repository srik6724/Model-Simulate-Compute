package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundLeftOverSpellsWriter(int round, String team) {
    try {
      file_writer = Round_Remaining.getFileWriter(team, round); 
      RoundLeftOverSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new RoundLeftOverSpellsWriter(round, "default"); 
    }
    return file_writer;
  }
}
