package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOutputSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondOutputSpellsTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Transducer.getFileWriter(team, round); 
      MicrosecondOutputSpellsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondOutputSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor."); 
      new MicrosecondOutputSpellsTeam2Writer("t2", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondOutputSpellsTeam2Writer.writerCreated = var; 
  }

}
