package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  VerbLeftOverSpellsTeam2Writer(String team) {
    try {
      file_writer = Verb_Remaining.getFileWriter(team);
      VerbLeftOverSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(VerbLeftOverSpellsTeam2Writer.writerCreated == true) {
      System.out.println("Calling domain_remaining constructor.");
      new VerbLeftOverSpellsTeam2Writer("t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
}
