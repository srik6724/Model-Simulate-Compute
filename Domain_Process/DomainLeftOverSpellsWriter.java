package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  DomainLeftOverSpellsWriter(String team) {
    try {
      file_writer = Domain_Remaining.getFileWriter(team); 
      DomainLeftOverSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(DomainLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new DomainLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainLeftOverSpellsWriter.writerCreated = var; 
  }
}
