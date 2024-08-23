package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondAudienceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondAudienceTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Engagement.getFileWriter(team, round);
      MicrosecondAudienceTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondAudienceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new MicrosecondAudienceTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondAudienceTeam2Writer.writerCreated = var; 
  }
}
