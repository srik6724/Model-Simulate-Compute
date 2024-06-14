package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundHistoryWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundHistoryWriter(int round, String team) {
    try {
      file_writer = Round_Documentation.getFileWriter(team, round);
      RoundHistoryWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundHistoryWriter.writerCreated == false) {
      System.out.println("Calling round_history constructor."); 
      new RoundHistoryWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundHistoryWriter.writerCreated = var; 
  }
}
