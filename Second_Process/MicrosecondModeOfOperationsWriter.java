package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondModeOfOperationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondModeOfOperationsWriter(int round, String team) {
    try {
      file_writer = Microsecond_Hierarchy.getFileWriter(team, round);
      MicrosecondModeOfOperationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondModeOfOperationsWriter.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new MicrosecondModeOfOperationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondModeOfOperationsWriter.writerCreated = var; 
  }
}
