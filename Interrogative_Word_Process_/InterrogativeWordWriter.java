package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

public class InterrogativeWordWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  InterrogativeWordWriter() {
    try {
      file_writer = Interrogative_Word_Finalizer.getFileWriter();
      InterrogativeWordWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static FileWriter get_file_writer() {
    if(InterrogativeWordWriter.writerCreated == false) {
      new InterrogativeWordWriter();
    }
    return file_writer;
  }
}
