package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondDiscardSpellsTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Discarder.getFileWriter(team, round);
      NanosecondDiscardSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new NanosecondDiscardSpellsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondDiscardSpellsTeam1Writer.writerCreated = var;
  }
}
