package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondRunTimeWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondRunTimeWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Process.getFileWriter(team, round); 
      NanosecondRunTimeWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondRunTimeWriter.writerCreated == false) {
      System.out.println("Calling round_run_time constructor"); 
      new NanosecondRunTimeWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondRunTimeWriter.writerCreated = var; 
  }
}
