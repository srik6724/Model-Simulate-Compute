package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer; 

  DomainLeftOverSpellsTeam1Writer(String team) {
    try {
      file_writer = Domain_Remaining.getFileWriter(team);
      DomainLeftOverSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(DomainLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new DomainLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
}
