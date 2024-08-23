package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTacticalApproachTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondTacticalApproachTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Strategy.getFileWriter(team, round); 
      MicrosecondTacticalApproachTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondTacticalApproachTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTacticalApproachTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTacticalApproachTeam2Writer.writerCreated = var; 
  }
}
