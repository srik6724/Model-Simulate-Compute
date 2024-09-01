package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

public class VerbWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  VerbWriter() {
    try {
      file_writer = Verb_Finalizer.getFileWriter();
      VerbWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static FileWriter get_file_writer() {
    if(VerbWriter.writerCreated == false) {
      new VerbWriter();
    }
    return file_writer;
  }
}
