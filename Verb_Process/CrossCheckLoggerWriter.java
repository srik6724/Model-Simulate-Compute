package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLoggerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckLoggerWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Logger.getFileWriter(team, round);
      CrossCheckLoggerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckLoggerWriter.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new CrossCheckLoggerWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLoggerWriter.writerCreated = var; 
  }
}
