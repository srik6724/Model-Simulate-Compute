package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondRunTimeTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondRunTimeTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Process.getFileWriter(team, round); 
      MicrosecondRunTimeTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondRunTimeTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new MicrosecondRunTimeTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondRunTimeTeam1Writer.writerCreated = var; 
  }
}
