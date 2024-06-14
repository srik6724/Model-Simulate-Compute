package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundReferencePointersTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundReferencePointersTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Simulation.getFileWriter(team, round); 
      RoundReferencePointersTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundReferencePointersTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new RoundReferencePointersTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundReferencePointersTeam1Writer.writerCreated = var; 
  }
}
