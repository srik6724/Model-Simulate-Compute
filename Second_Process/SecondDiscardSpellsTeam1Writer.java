package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class SecondDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  SecondDiscardSpellsTeam1Writer(String team) {
    try {
       file_writer = Second_Discarder.getFileWriter(team);
       SecondDiscardSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(SecondDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new SecondDiscardSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SecondDiscardSpellsTeam1Writer.writerCreated = var; 
  }
}
