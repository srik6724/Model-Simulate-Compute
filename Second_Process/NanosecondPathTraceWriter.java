package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPathTraceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  NanosecondPathTraceWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Induce.getFileWriter(team, round); 
      NanosecondPathTraceWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPathTraceWriter.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new NanosecondPathTraceWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPathTraceWriter.writerCreated = var; 
  }
}
