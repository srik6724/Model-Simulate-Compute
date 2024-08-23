package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOrderingPlacementsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondOrderingPlacementsTeam2Writer(String team, int round) {
    try { 
      file_writer = Microsecond_Solution.getFileWriter(team, round); 
      MicrosecondOrderingPlacementsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondOrderingPlacementsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new MicrosecondOrderingPlacementsTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondOrderingPlacementsTeam2Writer.writerCreated = var; 
  }
}
