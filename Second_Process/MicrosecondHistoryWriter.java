package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondHistoryWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondHistoryWriter(int round, String team) {
    try {
      file_writer = Microsecond_Documentation.getFileWriter(team, round);
      MicrosecondHistoryWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondHistoryWriter.writerCreated == false) {
      System.out.println("Calling round_history constructor."); 
      new MicrosecondHistoryWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondHistoryWriter.writerCreated = var; 
  }
}
