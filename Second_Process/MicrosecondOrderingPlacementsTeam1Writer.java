package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOrderingPlacementsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondOrderingPlacementsTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Permutations.getFileWriter(team, round); 
      MicrosecondOrderingPlacementsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondOrderingPlacementsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new MicrosecondOrderingPlacementsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondOrderingPlacementsTeam1Writer.writerCreated = var; 
  }
}
