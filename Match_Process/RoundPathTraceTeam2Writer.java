package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPathTraceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  RoundPathTraceTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Induce.getFileWriter(team, round); 
      RoundPathTraceTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPathTraceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new RoundPathTraceTeam2Writer("t2", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPathTraceTeam2Writer.writerCreated = var; 
  }
}
