package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckLeftOverSpellsTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Remaining.getFileWriter(team, round); 
      CrossCheckLeftOverSpellsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckLeftOverSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new CrossCheckLeftOverSpellsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
  
}
