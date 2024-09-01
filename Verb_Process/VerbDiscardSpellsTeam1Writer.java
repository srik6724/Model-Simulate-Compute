package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  VerbDiscardSpellsTeam1Writer(String team) {
    try {
       file_writer = Verb_Discarder.getFileWriter(team);
       VerbDiscardSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(VerbDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling verb_discarder constructor.");
      new VerbDiscardSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbDiscardSpellsTeam1Writer.writerCreated = var; 
  }
}
