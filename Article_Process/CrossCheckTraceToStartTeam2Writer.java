package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTraceToStartTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckTraceToStartTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Backtrack.getFileWriter(team, round); 
      CrossCheckTraceToStartTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckTraceToStartTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTraceToStartTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTraceToStartTeam2Writer.writerCreated = var; 
  }
}
