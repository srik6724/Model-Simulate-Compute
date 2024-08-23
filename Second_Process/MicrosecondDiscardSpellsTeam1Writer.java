package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondDiscardSpellsTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Discarder.getFileWriter(team, round);
      MicrosecondDiscardSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new MicrosecondDiscardSpellsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondDiscardSpellsTeam1Writer.writerCreated = var;
  }
}
