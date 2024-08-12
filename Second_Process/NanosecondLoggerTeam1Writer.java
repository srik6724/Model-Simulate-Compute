package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLoggerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondLoggerTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Logger.getFileWriter(team, round);
      NanosecondLoggerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondLoggerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new NanosecondLoggerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondLoggerTeam1Writer.writerCreated = var; 
  }
}
