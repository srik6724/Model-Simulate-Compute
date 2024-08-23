package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTraceToStartTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondTraceToStartTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Backtrack.getFileWriter(team, round); 
      MicrosecondTraceToStartTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondTraceToStartTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTraceToStartTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTraceToStartTeam1Writer.writerCreated = var; 
  }
}
