package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPathTraceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  MicrosecondPathTraceTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Induce.getFileWriter(team, round); 
      MicrosecondPathTraceTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPathTraceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new MicrosecondPathTraceTeam2Writer("t2", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPathTraceTeam2Writer.writerCreated = var; 
  }
}
