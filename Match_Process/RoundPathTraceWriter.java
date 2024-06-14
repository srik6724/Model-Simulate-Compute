package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPathTraceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  RoundPathTraceWriter(String team, int round) {
    try {
      file_writer = Round_Induce.getFileWriter(team, round); 
      RoundPathTraceWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPathTraceWriter.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new RoundPathTraceWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPathTraceWriter.writerCreated = var; 
  }
}
