package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLoggerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundLoggerTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Logger.getFileWriter(team, round);
      RoundLoggerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundLoggerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new RoundLoggerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundLoggerTeam1Writer.writerCreated = var; 
  }
}
