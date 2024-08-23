package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLoggerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondLoggerTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Logger.getFileWriter(team, round);
      MicrosecondLoggerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondLoggerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new MicrosecondLoggerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLoggerTeam2Writer.writerCreated = var; 
  }
}
