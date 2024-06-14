package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundReferencePointersWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundReferencePointersWriter(String team, int round) {
    try {
      file_writer = Round_Simulation.getFileWriter(team, round); 
      RoundReferencePointersWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundReferencePointersWriter.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new RoundReferencePointersWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundReferencePointersWriter.writerCreated = var; 
  }
}
