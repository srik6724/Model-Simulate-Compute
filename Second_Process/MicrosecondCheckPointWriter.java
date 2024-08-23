package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCheckPointWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  MicrosecondCheckPointWriter(String team, int round) {
    try {
      file_writer = Microsecond_State.getFileWriter(team, round);
      MicrosecondCheckPointWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondCheckPointWriter.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new MicrosecondCheckPointTeam1Writer("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondCheckPointWriter.writerCreated = var;
  }
}
