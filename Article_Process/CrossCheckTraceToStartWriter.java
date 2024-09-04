package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTraceToStartWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckTraceToStartWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Backtrack.getFileWriter(team, round); 
      CrossCheckTraceToStartWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckTraceToStartWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTraceToStartWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTraceToStartWriter.writerCreated = var; 
  }
}
