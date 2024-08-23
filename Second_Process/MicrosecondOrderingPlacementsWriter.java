package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOrderingPlacementsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondOrderingPlacementsWriter(String team, int round) {
    try {
      file_writer = Microsecond_Permutations.getFileWriter(team, round); 
      MicrosecondOrderingPlacementsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondOrderingPlacementsWriter.writerCreated == false) {
      System.out.println("Calling round_ordering_placements constructor"); 
      new MicrosecondOrderingPlacementsWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) { 
    MicrosecondOrderingPlacementsWriter.writerCreated = var; 
  }
}
