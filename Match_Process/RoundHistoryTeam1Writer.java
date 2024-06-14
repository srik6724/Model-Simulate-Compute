package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundHistoryTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundHistoryTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Documentation.getFileWriter(team, round);
      RoundHistoryTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundHistoryTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new RoundHistoryTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundHistoryTeam1Writer.writerCreated = var; 
  }
}
