package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondRunTimeTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondRunTimeTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Process.getFileWriter(team, round); 
      MicrosecondRunTimeTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondRunTimeTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new MicrosecondRunTimeTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondRunTimeTeam2Writer.writerCreated = var; 
  }
}
