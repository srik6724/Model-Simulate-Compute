package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondByMicrosecondWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondByMicrosecondWriter() {
    try {
      file_writer = Second_Recorder.getFileWriter(); 
      MicrosecondByMicrosecondWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MicrosecondByMicrosecondWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new MicrosecondByMicrosecondWriter(); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean val) {
    MicrosecondByMicrosecondWriter.writerCreated = val; 
  }

}
