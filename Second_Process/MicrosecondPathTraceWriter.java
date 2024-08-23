package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPathTraceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  MicrosecondPathTraceWriter(String team, int round) {
    try {
      file_writer = Microsecond_Induce.getFileWriter(team, round); 
      MicrosecondPathTraceWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPathTraceWriter.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new MicrosecondPathTraceWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPathTraceWriter.writerCreated = var; 
  }
}
