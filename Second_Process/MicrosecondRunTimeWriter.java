package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondRunTimeWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondRunTimeWriter(String team, int round) {
    try {
      file_writer = Microsecond_Process.getFileWriter(team, round); 
      MicrosecondRunTimeWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondRunTimeWriter.writerCreated == false) {
      System.out.println("Calling round_run_time constructor"); 
      new MicrosecondRunTimeWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondRunTimeWriter.writerCreated = var; 
  }
}
