package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondAudienceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondAudienceTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Engagement.getFileWriter(team, round);
      MicrosecondAudienceTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondAudienceTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new MicrosecondAudienceTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondAudienceTeam1Writer.writerCreated = var; 
  }
}
