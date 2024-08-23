package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCheckPointTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  MicrosecondCheckPointTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_State.getFileWriter(team, round);
      MicrosecondCheckPointTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondCheckPointTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new MicrosecondCheckPointTeam1Writer("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondCheckPointTeam1Writer.writerCreated = var; 
  }
}
