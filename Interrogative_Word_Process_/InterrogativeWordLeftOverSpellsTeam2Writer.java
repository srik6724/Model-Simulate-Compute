package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class InterrogativeWordLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  InterrogativeWordLeftOverSpellsTeam2Writer(String team) {
    try {
      file_writer = Interrogative_Word_Remaining.getFileWriter(team);
      InterrogativeWordLeftOverSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(InterrogativeWordLeftOverSpellsTeam2Writer.writerCreated == true) {
      System.out.println("Calling domain_remaining constructor.");
      new InterrogativeWordLeftOverSpellsTeam2Writer("t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    InterrogativeWordLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
}
