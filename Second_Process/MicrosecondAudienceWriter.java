package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondAudienceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondAudienceWriter(String team, int round) {
    try {
      file_writer = Microsecond_Engagement.getFileWriter(team, round);
      MicrosecondAudienceWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondAudienceWriter.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new MicrosecondAudienceWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondAudienceWriter.writerCreated = var; 
  }
}
