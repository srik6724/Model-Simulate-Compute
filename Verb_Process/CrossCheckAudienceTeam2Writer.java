package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckAudienceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckAudienceTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Engagement.getFileWriter(team, round);
      CrossCheckAudienceTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckAudienceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new CrossCheckAudienceTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckAudienceTeam2Writer.writerCreated = var; 
  }
}
