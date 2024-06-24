package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  DomainLeftOverSpellsTeam2Writer(String team) {
    try {
      file_writer = Domain_Remaining.getFileWriter(team);
      DomainLeftOverSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(DomainLeftOverSpellsTeam2Writer.writerCreated == true) {
      System.out.println("Calling domain_remaining constructor.");
      new DomainLeftOverSpellsTeam2Writer("t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
}
