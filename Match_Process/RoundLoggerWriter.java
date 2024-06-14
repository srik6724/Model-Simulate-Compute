package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLoggerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundLoggerWriter(int round, String team) {
    try {
      file_writer = Round_Logger.getFileWriter(team, round);
      RoundLoggerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundLoggerWriter.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new RoundLoggerWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundLoggerWriter.writerCreated = var; 
  }
}
