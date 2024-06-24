package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  DomainDiscardSpellsTeam1Writer(String team) {
    try {
       file_writer = Domain_Discarder.getFileWriter(team);
       DomainDiscardSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(DomainDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new DomainDiscardSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainDiscardSpellsTeam1Writer.writerCreated = var; 
  }
}
