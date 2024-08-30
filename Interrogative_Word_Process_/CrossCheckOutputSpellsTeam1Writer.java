package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOutputSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckOutputSpellsTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Transducer.getFileWriter(team, round); 
      CrossCheckOutputSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckOutputSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new CrossCheckOutputSpellsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckOutputSpellsTeam1Writer.writerCreated = var; 
  }
}
