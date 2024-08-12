package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondAudienceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondAudienceTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Engagement.getFileWriter(team, round);
      NanosecondAudienceTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondAudienceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new NanosecondAudienceTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondAudienceTeam2Writer.writerCreated = var; 
  }
}
