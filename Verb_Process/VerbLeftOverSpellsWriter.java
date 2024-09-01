package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  VerbLeftOverSpellsWriter(String team) {
    try {
      file_writer = Verb_Remaining.getFileWriter(team); 
      VerbLeftOverSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(VerbLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new VerbLeftOverSpellsWriter("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbLeftOverSpellsWriter.writerCreated = var; 
  }
}
