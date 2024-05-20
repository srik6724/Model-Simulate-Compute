package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundDiscardSpellsWriter(int round, String team) {
    try {
      file_writer = Round_Discarder.getFileWriter(team, round); 
      RoundDiscardSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundDiscardSpellsWriter.writerCreated == true) {
      System.out.println("Calling round_remaining constructor.");
      new RoundDiscardSpellsWriter(round, "default");
    }
    return file_writer;
  }
}
