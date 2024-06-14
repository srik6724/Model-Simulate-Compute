package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundAudienceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundAudienceWriter(String team, int round) {
    try {
      file_writer = Round_Engagement.getFileWriter(team, round);
      RoundAudienceWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundAudienceWriter.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new RoundAudienceWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundAudienceWriter.writerCreated = var; 
  }
}
