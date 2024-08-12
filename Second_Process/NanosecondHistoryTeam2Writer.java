package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondHistoryTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondHistoryTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Documentation.getFileWriter(team, round);
      NanosecondHistoryTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondHistoryTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new NanosecondHistoryTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondHistoryTeam2Writer.writerCreated = var; 
  }
}
