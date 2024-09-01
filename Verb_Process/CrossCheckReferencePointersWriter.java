package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckReferencePointersWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckReferencePointersWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Simulation.getFileWriter(team, round); 
      CrossCheckReferencePointersWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckReferencePointersWriter.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new CrossCheckReferencePointersWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckReferencePointersWriter.writerCreated = var; 
  }
}
