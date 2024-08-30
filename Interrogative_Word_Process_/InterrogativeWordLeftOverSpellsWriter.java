package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class InterrogativeWordLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  InterrogativeWordLeftOverSpellsWriter(String team) {
    try {
      file_writer = Interrogative_Word_Remaining.getFileWriter(team); 
      InterrogativeWordLeftOverSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(InterrogativeWordLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new InterrogativeWordLeftOverSpellsWriter("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    InterrogativeWordLeftOverSpellsWriter.writerCreated = var; 
  }
}
