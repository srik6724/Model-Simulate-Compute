package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLoggerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckLoggerTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Logger.getFileWriter(team, round);
      CrossCheckLoggerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckLoggerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new CrossCheckLoggerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLoggerTeam2Writer.writerCreated = var; 
  }
}
