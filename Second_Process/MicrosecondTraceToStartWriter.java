package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTraceToStartWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondTraceToStartWriter(String team, int round) {
    try {
      file_writer = Microsecond_Backtrack.getFileWriter(team, round); 
      MicrosecondTraceToStartWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondTraceToStartWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTraceToStartWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTraceToStartWriter.writerCreated = var; 
  }
}
