package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckByCrossCheckWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckByCrossCheckWriter() {
    try {
      file_writer = Article_Recorder.getFileWriter(); 
      CrossCheckByCrossCheckWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CrossCheckByCrossCheckWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new CrossCheckByCrossCheckWriter(); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean val) {
    CrossCheckByCrossCheckWriter.writerCreated = val; 
  }

}
