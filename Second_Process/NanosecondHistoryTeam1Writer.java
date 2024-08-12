package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondHistoryTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondHistoryTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Documentation.getFileWriter(team, round);
      NanosecondHistoryTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondHistoryTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new NanosecondHistoryTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondHistoryTeam1Writer.writerCreated = var; 
  }
}
