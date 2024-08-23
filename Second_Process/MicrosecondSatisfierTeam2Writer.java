package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondSatisfierTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondSatisfierTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Solution.getFileWriter(team, round); 
      MicrosecondSatisfierTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondSatisfierTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new MicrosecondSatisfierTeam1Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondSatisfierTeam2Writer.writerCreated = var; 
  }
}
