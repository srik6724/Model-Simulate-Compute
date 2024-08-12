package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondRunTimeTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondRunTimeTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Process.getFileWriter(team, round); 
      NanosecondRunTimeTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondRunTimeTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new NanosecondRunTimeTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondRunTimeTeam1Writer.writerCreated = var; 
  }
}
