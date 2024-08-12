package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOutputSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondOutputSpellsTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Transducer.getFileWriter(team, round); 
      NanosecondOutputSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondOutputSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new NanosecondOutputSpellsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondOutputSpellsTeam1Writer.writerCreated = var; 
  }
}
