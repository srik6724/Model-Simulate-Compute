package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundRunTimeWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundRunTimeWriter(String team, int round) {
    try {
      file_writer = Round_Process.getFileWriter(team, round); 
      RoundRunTimeWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundRunTimeWriter.writerCreated == false) {
      System.out.println("Calling round_run_time constructor"); 
      new RoundRunTimeWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundRunTimeWriter.writerCreated = var; 
  }
}
