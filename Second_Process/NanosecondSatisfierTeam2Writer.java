package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondSatisfierTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondSatisfierTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Solution.getFileWriter(team, round); 
      NanosecondSatisfierTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondSatisfierTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new NanosecondSatisfierTeam1Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondSatisfierTeam2Writer.writerCreated = var; 
  }
}
