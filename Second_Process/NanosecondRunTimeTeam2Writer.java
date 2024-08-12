package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondRunTimeTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondRunTimeTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Process.getFileWriter(team, round); 
      NanosecondRunTimeTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondRunTimeTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new NanosecondRunTimeTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondRunTimeTeam2Writer.writerCreated = var; 
  }
}
