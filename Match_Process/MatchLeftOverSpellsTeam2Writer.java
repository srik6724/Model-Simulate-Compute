package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class MatchLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  MatchLeftOverSpellsTeam2Writer(String team) {
    try {
      file_writer = Match_Remaining.getFileWriter(team);
      MatchLeftOverSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchLeftOverSpellsTeam2Writer.writerCreated == true) {
      System.out.println("Calling match_remaining constructor.");
      new MatchLeftOverSpellsTeam2Writer("t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
}
