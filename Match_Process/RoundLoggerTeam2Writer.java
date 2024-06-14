package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLoggerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundLoggerTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Logger.getFileWriter(team, round);
      RoundLoggerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundLoggerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new RoundLoggerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundLoggerTeam2Writer.writerCreated = var; 
  }
}
