package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class InterrogativeWordDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  InterrogativeWordDiscardSpellsTeam2Writer(String team) {
    try {
      file_writer = Interrogative_Word_Discarder.getFileWriter(team);
      InterrogativeWordDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(InterrogativeWordDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new InterrogativeWordDiscardSpellsTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    InterrogativeWordDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
