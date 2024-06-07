package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOutputSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundOutputSpellsTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Transducer.getFileWriter(team, round); 
      RoundOutputSpellsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundOutputSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor."); 
      new RoundOutputSpellsTeam2Writer("t2", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundOutputSpellsTeam2Writer.writerCreated = var; 
  }

}
