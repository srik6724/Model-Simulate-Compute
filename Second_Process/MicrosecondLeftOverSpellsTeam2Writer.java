package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondLeftOverSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Remaining.getFileWriter(team, round); 
      MicrosecondLeftOverSpellsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondLeftOverSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new MicrosecondLeftOverSpellsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
  
}
