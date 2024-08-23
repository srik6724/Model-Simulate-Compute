package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTacticalApproachTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondTacticalApproachTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Strategy.getFileWriter(team, round); 
      MicrosecondTacticalApproachTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondTacticalApproachTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTacticalApproachTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTacticalApproachTeam1Writer.writerCreated = var; 
  }
}
