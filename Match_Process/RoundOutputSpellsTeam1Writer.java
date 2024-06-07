package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOutputSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundOutputSpellsTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Transducer.getFileWriter(team, round); 
      RoundOutputSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundOutputSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new RoundOutputSpellsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundOutputSpellsTeam1Writer.writerCreated = var; 
  }
}
