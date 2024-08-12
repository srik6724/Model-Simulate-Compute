package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTraceToStartTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondTraceToStartTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Backtrack.getFileWriter(team, round); 
      NanosecondTraceToStartTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondTraceToStartTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondTraceToStartTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondTraceToStartTeam2Writer.writerCreated = var; 
  }
}
