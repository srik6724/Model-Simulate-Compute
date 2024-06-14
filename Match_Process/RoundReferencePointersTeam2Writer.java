package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundReferencePointersTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundReferencePointersTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Simulation.getFileWriter(team, round); 
      RoundReferencePointersTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundReferencePointersTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new RoundReferencePointersTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundReferencePointersTeam2Writer.writerCreated = var; 
  }
}
