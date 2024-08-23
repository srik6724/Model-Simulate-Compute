package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondHistoryTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondHistoryTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Documentation.getFileWriter(team, round);
      MicrosecondHistoryTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondHistoryTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new MicrosecondHistoryTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondHistoryTeam1Writer.writerCreated = var; 
  }
}
