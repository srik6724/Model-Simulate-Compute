package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOutputSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondOutputSpellsTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Transducer.getFileWriter(team, round); 
      MicrosecondOutputSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondOutputSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new MicrosecondOutputSpellsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondOutputSpellsTeam1Writer.writerCreated = var; 
  }
}
