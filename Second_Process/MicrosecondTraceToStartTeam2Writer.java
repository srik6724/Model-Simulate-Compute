package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTraceToStartTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondTraceToStartTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Backtrack.getFileWriter(team, round); 
      MicrosecondTraceToStartTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondTraceToStartTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTraceToStartTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTraceToStartTeam2Writer.writerCreated = var; 
  }
}
