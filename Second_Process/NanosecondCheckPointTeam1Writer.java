package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCheckPointTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  NanosecondCheckPointTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_State.getFileWriter(team, round);
      NanosecondCheckPointTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondCheckPointTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new NanosecondCheckPointTeam1Writer("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondCheckPointTeam1Writer.writerCreated = var; 
  }
}
