package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckAudienceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckAudienceWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Engagement.getFileWriter(team, round);
      CrossCheckAudienceWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckAudienceWriter.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new CrossCheckAudienceWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckAudienceWriter.writerCreated = var; 
  }
}
