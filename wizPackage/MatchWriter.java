package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

public class MatchWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MatchWriter() {
    try {
      file_writer = Match_Recorder.getFileWriter();
      MatchWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }

  static FileWriter get_file_writer() {
    if(MatchWriter.writerCreated == false) {
      new MatchWriter(); 
    }
    return file_writer; 
  }
}
