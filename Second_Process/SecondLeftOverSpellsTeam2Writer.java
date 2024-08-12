package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class SecondLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  SecondLeftOverSpellsTeam2Writer(String team) {
    try {
      file_writer = Second_Remaining.getFileWriter(team);
      SecondLeftOverSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(SecondLeftOverSpellsTeam2Writer.writerCreated == true) {
      System.out.println("Calling domain_remaining constructor.");
      new SecondLeftOverSpellsTeam2Writer("t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SecondLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
}
