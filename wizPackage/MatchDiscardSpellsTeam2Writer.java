package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class MatchDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MatchDiscardSpellsTeam2Writer(String team) {
    try {
      file_writer = Match_Discarder.getFileWriter(team);
      MatchDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling match_discarder constructor.");
      new MatchDiscardSpellsTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
