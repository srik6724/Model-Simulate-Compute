package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTraceToStartTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondTraceToStartTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Backtrack.getFileWriter(team, round); 
      NanosecondTraceToStartTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondTraceToStartTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondTraceToStartTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondTraceToStartTeam1Writer.writerCreated = var; 
  }
}
