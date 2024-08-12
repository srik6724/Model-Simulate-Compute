package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOrderingPlacementsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondOrderingPlacementsTeam2Writer(String team, int round) {
    try { 
      file_writer = Nanosecond_Solution.getFileWriter(team, round); 
      NanosecondOrderingPlacementsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondOrderingPlacementsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new NanosecondOrderingPlacementsTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondOrderingPlacementsTeam2Writer.writerCreated = var; 
  }
}
