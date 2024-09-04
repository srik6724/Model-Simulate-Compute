package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOrderingPlacementsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckOrderingPlacementsWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Permutations.getFileWriter(team, round); 
      CrossCheckOrderingPlacementsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckOrderingPlacementsWriter.writerCreated == false) {
      System.out.println("Calling round_ordering_placements constructor"); 
      new CrossCheckOrderingPlacementsWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) { 
    CrossCheckOrderingPlacementsWriter.writerCreated = var; 
  }
}
