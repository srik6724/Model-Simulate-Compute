package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class MatchDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  MatchDiscardSpellsTeam1Writer(String team) {
    try {
       file_writer = Match_Discarder.getFileWriter(team);
       MatchDiscardSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling match_discarder constructor.");
      new MatchDiscardSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchDiscardSpellsTeam1Writer.writerCreated = var; 
  }
}
