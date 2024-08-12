package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondReferencePointersTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondReferencePointersTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Simulation.getFileWriter(team, round); 
      NanosecondReferencePointersTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondReferencePointersTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new NanosecondReferencePointersTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondReferencePointersTeam2Writer.writerCreated = var; 
  }
}
