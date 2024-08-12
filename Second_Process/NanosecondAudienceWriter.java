package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondAudienceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondAudienceWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Engagement.getFileWriter(team, round);
      NanosecondAudienceWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondAudienceWriter.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new NanosecondAudienceWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondAudienceWriter.writerCreated = var; 
  }
}
