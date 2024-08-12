package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

public class SecondWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  SecondWriter() {
    try {
      file_writer = Second_Finalizer.getFileWriter();
      SecondWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static FileWriter get_file_writer() {
    if(SecondWriter.writerCreated == false) {
      new SecondWriter();
    }
    return file_writer;
  }
}
