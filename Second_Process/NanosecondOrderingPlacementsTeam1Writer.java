package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOrderingPlacementsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondOrderingPlacementsTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Permutations.getFileWriter(team, round); 
      NanosecondOrderingPlacementsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondOrderingPlacementsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new NanosecondOrderingPlacementsTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondOrderingPlacementsTeam1Writer.writerCreated = var; 
  }
}
