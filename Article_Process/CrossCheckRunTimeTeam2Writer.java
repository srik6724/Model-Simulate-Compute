package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckRunTimeTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckRunTimeTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Process.getFileWriter(team, round); 
      CrossCheckRunTimeTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckRunTimeTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new CrossCheckRunTimeTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckRunTimeTeam2Writer.writerCreated = var; 
  }
}
