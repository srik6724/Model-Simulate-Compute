package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class SecondLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer; 

  SecondLeftOverSpellsTeam1Writer(String team) {
    try {
      file_writer = Second_Remaining.getFileWriter(team);
      SecondLeftOverSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(SecondLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new SecondLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SecondLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
}
