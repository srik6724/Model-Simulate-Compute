package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckLeftOverSpellsTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Remaining.getFileWriter(team, round);
      CrossCheckLeftOverSpellsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new CrossCheckLeftOverSpellsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
  
}
