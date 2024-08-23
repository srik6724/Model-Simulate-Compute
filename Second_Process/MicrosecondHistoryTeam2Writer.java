package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondHistoryTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondHistoryTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Documentation.getFileWriter(team, round);
      MicrosecondHistoryTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondHistoryTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new MicrosecondHistoryTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondHistoryTeam2Writer.writerCreated = var; 
  }
}
