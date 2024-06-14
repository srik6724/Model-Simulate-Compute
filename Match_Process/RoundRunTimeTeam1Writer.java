package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundRunTimeTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundRunTimeTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Process.getFileWriter(team, round); 
      RoundRunTimeTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundRunTimeTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new RoundRunTimeTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundRunTimeTeam1Writer.writerCreated = var; 
  }
}
