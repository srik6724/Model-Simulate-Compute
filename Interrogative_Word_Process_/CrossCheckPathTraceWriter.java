package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPathTraceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  CrossCheckPathTraceWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Induce.getFileWriter(team, round); 
      CrossCheckPathTraceWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPathTraceWriter.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new CrossCheckPathTraceWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPathTraceWriter.writerCreated = var; 
  }
}
