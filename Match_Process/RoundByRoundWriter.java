package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundByRoundWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundByRoundWriter() {
    try {
      file_writer = Match_Recorder.getFileWriter(); 
      RoundByRoundWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(RoundByRoundWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new RoundByRoundWriter(); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean val) {
    RoundByRoundWriter.writerCreated = val; 
  }

}
