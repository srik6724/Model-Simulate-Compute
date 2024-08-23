package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondLeftOverSpellsTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Remaining.getFileWriter(team, round);
      MicrosecondLeftOverSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new MicrosecondLeftOverSpellsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
  
}
