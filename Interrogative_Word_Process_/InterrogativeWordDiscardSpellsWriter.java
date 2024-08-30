package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class InterrogativeWordDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  InterrogativeWordDiscardSpellsWriter(String team) {
    try {
      file_writer = Interrogative_Word_Discarder.getFileWriter("default");
      InterrogativeWordDiscardSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(InterrogativeWordDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new InterrogativeWordDiscardSpellsWriter("default");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    InterrogativeWordDiscardSpellsWriter.writerCreated = var;
  }

}
