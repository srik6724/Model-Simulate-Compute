package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckRunTimeWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckRunTimeWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Process.getFileWriter(team, round); 
      CrossCheckRunTimeWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckRunTimeWriter.writerCreated == false) {
      System.out.println("Calling round_run_time constructor"); 
      new CrossCheckRunTimeWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckRunTimeWriter.writerCreated = var; 
  }
}
