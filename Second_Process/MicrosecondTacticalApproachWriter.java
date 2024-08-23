package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTacticalApproachWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondTacticalApproachWriter(String team, int round) {
    try {
      file_writer = Microsecond_Strategy.getFileWriter(team, round); 
      MicrosecondTacticalApproachWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondTacticalApproachWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTacticalApproachWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTacticalApproachWriter.writerCreated = var; 
  }
}
