package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class MatchLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  MatchLeftOverSpellsWriter(String team) {
    try {
      file_writer = Match_Remaining.getFileWriter(team); 
      MatchLeftOverSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling match_remaining constructor.");
      new MatchLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchLeftOverSpellsWriter.writerCreated = var; 
  }
}
