package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPathTraceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  RoundPathTraceTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Induce.getFileWriter(team, round); 
      RoundPathTraceTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPathTraceTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new RoundPathTraceTeam1Writer("t1", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPathTraceTeam1Writer.writerCreated = var; 
  }
}
