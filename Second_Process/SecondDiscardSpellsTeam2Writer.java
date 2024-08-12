package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class SecondDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  SecondDiscardSpellsTeam2Writer(String team) {
    try {
      file_writer = Second_Discarder.getFileWriter(team);
      SecondDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(SecondDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new SecondDiscardSpellsTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SecondDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
