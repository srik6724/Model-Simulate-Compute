package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckRunTimeTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckRunTimeTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Process.getFileWriter(team, round); 
      CrossCheckRunTimeTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckRunTimeTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new CrossCheckRunTimeTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckRunTimeTeam1Writer.writerCreated = var; 
  }
}
