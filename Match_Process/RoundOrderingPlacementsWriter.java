package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOrderingPlacementsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundOrderingPlacementsWriter(String team, int round) {
    try {
      file_writer = Round_Permutations.getFileWriter(team, round); 
      RoundOrderingPlacementsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundOrderingPlacementsWriter.writerCreated == false) {
      System.out.println("Calling round_ordering_placements constructor"); 
      new RoundOrderingPlacementsWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) { 
    RoundOrderingPlacementsWriter.writerCreated = var; 
  }
}
