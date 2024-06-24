package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  DomainDiscardSpellsWriter(String team) {
    try {
      file_writer = Domain_Discarder.getFileWriter("default");
      DomainDiscardSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(DomainDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new DomainDiscardSpellsWriter("default");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainDiscardSpellsWriter.writerCreated = var;
  }

}
