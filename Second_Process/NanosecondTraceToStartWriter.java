package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTraceToStartWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondTraceToStartWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Backtrack.getFileWriter(team, round); 
      NanosecondTraceToStartWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondTraceToStartWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondTraceToStartWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondTraceToStartWriter.writerCreated = var; 
  }
}
