package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer; 

  VerbLeftOverSpellsTeam1Writer(String team) {
    try {
      file_writer = Verb_Remaining.getFileWriter(team);
      VerbLeftOverSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(VerbLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new VerbLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
}
