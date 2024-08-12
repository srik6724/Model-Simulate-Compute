package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTacticalApproachTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondTacticalApproachTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Strategy.getFileWriter(team, round); 
      NanosecondTacticalApproachTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondTacticalApproachTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondTacticalApproachTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondTacticalApproachTeam1Writer.writerCreated = var; 
  }
}
