package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondDiscardSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Discarder.getFileWriter(team, round);
      MicrosecondDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  static FileWriter get_file_writer(int round) {
    if(MicrosecondDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new MicrosecondDiscardSpellsTeam2Writer(round, "t2");
    }
    return file_writer;
  }


  static void setWriterCreated(boolean var) {
    MicrosecondDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
