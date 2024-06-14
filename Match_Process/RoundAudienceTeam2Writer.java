package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundAudienceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundAudienceTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Engagement.getFileWriter(team, round);
      RoundAudienceTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundAudienceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new RoundAudienceTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundAudienceTeam2Writer.writerCreated = var; 
  }
}
