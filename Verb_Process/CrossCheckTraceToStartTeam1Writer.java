package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTraceToStartTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckTraceToStartTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Backtrack.getFileWriter(team, round); 
      CrossCheckTraceToStartTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckTraceToStartTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTraceToStartTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTraceToStartTeam1Writer.writerCreated = var; 
  }
}
