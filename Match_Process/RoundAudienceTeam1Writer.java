package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundAudienceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundAudienceTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Engagement.getFileWriter(team, round);
      RoundAudienceTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundAudienceTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new RoundAudienceTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundAudienceTeam1Writer.writerCreated = var; 
  }
}
