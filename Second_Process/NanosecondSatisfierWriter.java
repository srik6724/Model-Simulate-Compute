package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondSatisfierWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondSatisfierWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Solution.getFileWriter(team, round); 
      NanosecondSatisfierWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondSatisfierWriter.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new NanosecondSatisfierWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondSatisfierWriter.writerCreated = var; 
  }
}
