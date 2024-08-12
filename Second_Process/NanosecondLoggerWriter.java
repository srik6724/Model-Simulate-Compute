package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLoggerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondLoggerWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Logger.getFileWriter(team, round);
      NanosecondLoggerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondLoggerWriter.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new NanosecondLoggerWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondLoggerWriter.writerCreated = var; 
  }
}
