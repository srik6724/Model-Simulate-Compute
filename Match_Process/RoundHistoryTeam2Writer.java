package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundHistoryTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundHistoryTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Documentation.getFileWriter(team, round);
      RoundHistoryTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundHistoryTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new RoundHistoryTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundHistoryTeam2Writer.writerCreated = var; 
  }
}
