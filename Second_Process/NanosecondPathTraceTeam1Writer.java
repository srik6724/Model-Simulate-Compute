package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPathTraceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  NanosecondPathTraceTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Induce.getFileWriter(team, round); 
      NanosecondPathTraceTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPathTraceTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new NanosecondPathTraceTeam1Writer("t1", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPathTraceTeam1Writer.writerCreated = var; 
  }
}
