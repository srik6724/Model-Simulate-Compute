package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondSatisfierWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondSatisfierWriter(String team, int round) {
    try {
      file_writer = Microsecond_Solution.getFileWriter(team, round); 
      MicrosecondSatisfierWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondSatisfierWriter.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new MicrosecondSatisfierWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondSatisfierWriter.writerCreated = var; 
  }
}
