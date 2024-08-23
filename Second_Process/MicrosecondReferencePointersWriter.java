package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondReferencePointersWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondReferencePointersWriter(String team, int round) {
    try {
      file_writer = Microsecond_Simulation.getFileWriter(team, round); 
      MicrosecondReferencePointersWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondReferencePointersWriter.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new MicrosecondReferencePointersWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondReferencePointersWriter.writerCreated = var; 
  }
}
