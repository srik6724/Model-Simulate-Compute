package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOutputSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckOutputSpellsTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Transducer.getFileWriter(team, round); 
      CrossCheckOutputSpellsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckOutputSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor."); 
      new CrossCheckOutputSpellsTeam2Writer("t2", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckOutputSpellsTeam2Writer.writerCreated = var; 
  }

}
