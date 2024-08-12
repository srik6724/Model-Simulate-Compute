package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondReferencePointersWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondReferencePointersWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Simulation.getFileWriter(team, round); 
      NanosecondReferencePointersWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondReferencePointersWriter.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new NanosecondReferencePointersWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondReferencePointersWriter.writerCreated = var; 
  }
}
