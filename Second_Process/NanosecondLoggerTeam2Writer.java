package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLoggerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondLoggerTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Logger.getFileWriter(team, round);
      NanosecondLoggerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondLoggerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new NanosecondLoggerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondLoggerTeam2Writer.writerCreated = var; 
  }
}
