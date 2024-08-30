package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class InterrogativeWordLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer; 

  InterrogativeWordLeftOverSpellsTeam1Writer(String team) {
    try {
      file_writer = Interrogative_Word_Remaining.getFileWriter(team);
      InterrogativeWordLeftOverSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(InterrogativeWordLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new InterrogativeWordLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    InterrogativeWordLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
}
