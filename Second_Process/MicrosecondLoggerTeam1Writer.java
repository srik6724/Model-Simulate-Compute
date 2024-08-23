package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLoggerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondLoggerTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Logger.getFileWriter(team, round);
      MicrosecondLoggerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondLoggerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_logger constructor."); 
      new MicrosecondLoggerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLoggerTeam1Writer.writerCreated = var; 
  }
}
