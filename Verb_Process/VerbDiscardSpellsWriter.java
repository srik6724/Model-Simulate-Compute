package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  VerbDiscardSpellsWriter(String team) {
    try {
      file_writer = Verb_Discarder.getFileWriter("default");
      VerbDiscardSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(VerbDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new VerbDiscardSpellsWriter("default");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbDiscardSpellsWriter.writerCreated = var;
  }

}
