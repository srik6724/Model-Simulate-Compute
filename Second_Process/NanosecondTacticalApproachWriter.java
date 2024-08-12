package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTacticalApproachWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondTacticalApproachWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Strategy.getFileWriter(team, round); 
      NanosecondTacticalApproachWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondTacticalApproachWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondTacticalApproachWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondTacticalApproachWriter.writerCreated = var; 
  }
}
