package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  VerbDiscardSpellsTeam2Writer(String team) {
    try {
      file_writer = Verb_Discarder.getFileWriter(team);
      VerbDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(VerbDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling verb_discarder constructor.");
      new VerbDiscardSpellsTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
