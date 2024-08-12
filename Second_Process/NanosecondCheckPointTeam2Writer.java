package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCheckPointTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  NanosecondCheckPointTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_State.getFileWriter(team, round);
      NanosecondCheckPointTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondCheckPointTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new NanosecondCheckPointTeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondCheckPointTeam2Writer.writerCreated = var; 
  }

}
