package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLoggerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckLoggerTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Logger.getFileWriter(team, round);
      CrossCheckLoggerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckLoggerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new CrossCheckLoggerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLoggerTeam1Writer.writerCreated = var; 
  }
}
