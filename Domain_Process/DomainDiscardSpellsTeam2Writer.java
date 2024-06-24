package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  DomainDiscardSpellsTeam2Writer(String team) {
    try {
      file_writer = Domain_Discarder.getFileWriter(team);
      DomainDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(DomainDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new DomainDiscardSpellsTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
