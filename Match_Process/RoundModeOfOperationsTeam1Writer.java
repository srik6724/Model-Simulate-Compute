package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundModeOfOperationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundModeOfOperationsTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Hierarchy.getFileWriter(team, round);
      RoundModeOfOperationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundModeOfOperationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new RoundModeOfOperationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundModeOfOperationsTeam1Writer.writerCreated = var; 
  }
}
