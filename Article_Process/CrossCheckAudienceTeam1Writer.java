package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckAudienceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckAudienceTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Engagement.getFileWriter(team, round);
      CrossCheckAudienceTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckAudienceTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new CrossCheckAudienceTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckAudienceTeam1Writer.writerCreated = var; 
  }
}
