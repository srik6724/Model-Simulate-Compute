package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOrderingPlacementsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondOrderingPlacementsWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Permutations.getFileWriter(team, round); 
      NanosecondOrderingPlacementsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondOrderingPlacementsWriter.writerCreated == false) {
      System.out.println("Calling round_ordering_placements constructor"); 
      new NanosecondOrderingPlacementsWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) { 
    NanosecondOrderingPlacementsWriter.writerCreated = var; 
  }
}
