package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundRunTimeTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundRunTimeTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Process.getFileWriter(team, round); 
      RoundRunTimeTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundRunTimeTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new RoundRunTimeTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundRunTimeTeam2Writer.writerCreated = var; 
  }
}
