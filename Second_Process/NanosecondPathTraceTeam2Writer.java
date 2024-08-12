package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPathTraceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  NanosecondPathTraceTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Induce.getFileWriter(team, round); 
      NanosecondPathTraceTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPathTraceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new NanosecondPathTraceTeam2Writer("t2", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPathTraceTeam2Writer.writerCreated = var; 
  }
}
