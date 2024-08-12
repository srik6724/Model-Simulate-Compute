package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondLeftOverSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Remaining.getFileWriter(team, round); 
      NanosecondLeftOverSpellsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondLeftOverSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new NanosecondLeftOverSpellsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
  
}
