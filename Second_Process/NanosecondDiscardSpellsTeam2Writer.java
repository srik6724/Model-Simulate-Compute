package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondDiscardSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Discarder.getFileWriter(team, round);
      NanosecondDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  static FileWriter get_file_writer(int round) {
    if(NanosecondDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new NanosecondDiscardSpellsTeam2Writer(round, "t2");
    }
    return file_writer;
  }


  static void setWriterCreated(boolean var) {
    NanosecondDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
