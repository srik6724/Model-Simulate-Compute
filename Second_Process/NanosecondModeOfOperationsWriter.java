package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondModeOfOperationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondModeOfOperationsWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Hierarchy.getFileWriter(team, round);
      NanosecondModeOfOperationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondModeOfOperationsWriter.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new NanosecondModeOfOperationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondModeOfOperationsWriter.writerCreated = var; 
  }
}
