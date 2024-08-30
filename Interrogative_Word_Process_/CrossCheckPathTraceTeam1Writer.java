package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPathTraceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  CrossCheckPathTraceTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Induce.getFileWriter(team, round); 
      CrossCheckPathTraceTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPathTraceTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new CrossCheckPathTraceTeam1Writer("t1", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPathTraceTeam1Writer.writerCreated = var; 
  }
}
