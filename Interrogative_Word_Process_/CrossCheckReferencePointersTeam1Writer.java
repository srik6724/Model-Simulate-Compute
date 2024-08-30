package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckReferencePointersTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckReferencePointersTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Simulation.getFileWriter(team, round); 
      CrossCheckReferencePointersTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckReferencePointersTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new CrossCheckReferencePointersTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckReferencePointersTeam1Writer.writerCreated = var; 
  }
}
