package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class MatchLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer; 

  MatchLeftOverSpellsTeam1Writer(String team) {
    try {
      file_writer = Match_Remaining.getFileWriter(team);
      MatchLeftOverSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling match_remaining constructor.");
      new MatchLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
}
