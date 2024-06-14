package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundModeOfOperationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundModeOfOperationsTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Hierarchy.getFileWriter(team, round);
      RoundModeOfOperationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundModeOfOperationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new RoundModeOfOperationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundModeOfOperationsTeam2Writer.writerCreated = var; 
  }
}
