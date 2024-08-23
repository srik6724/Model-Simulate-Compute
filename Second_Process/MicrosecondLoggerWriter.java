package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLoggerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondLoggerWriter(int round, String team) {
    try {
      file_writer = Microsecond_Logger.getFileWriter(team, round);
      MicrosecondLoggerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondLoggerWriter.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new MicrosecondLoggerWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLoggerWriter.writerCreated = var; 
  }
}
