package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondSatisfierTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondSatisfierTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Solution.getFileWriter(team, round); 
      NanosecondSatisfierTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondSatisfierTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new NanosecondSatisfierTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondSatisfierTeam1Writer.writerCreated = var; 
  }
}
