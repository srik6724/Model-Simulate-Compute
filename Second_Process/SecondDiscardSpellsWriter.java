package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class SecondDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  SecondDiscardSpellsWriter(String team) {
    try {
      file_writer = Second_Discarder.getFileWriter("default");
      SecondDiscardSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(SecondDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new SecondDiscardSpellsWriter("default");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SecondDiscardSpellsWriter.writerCreated = var;
  }

}
