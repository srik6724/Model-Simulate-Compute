package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPathTraceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  CrossCheckPathTraceTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Induce.getFileWriter(team, round); 
      CrossCheckPathTraceTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPathTraceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new CrossCheckPathTraceTeam2Writer("t2", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPathTraceTeam2Writer.writerCreated = var; 
  }
}
