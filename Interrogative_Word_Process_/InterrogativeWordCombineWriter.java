package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class InterrogativeWordCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;
  
  InterrogativeWordCombineWriter() {
    try {
      file_writer = Interrogative_Word_Merge_Finalizer.getFileWriter(); 
      InterrogativeWordCombineWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(InterrogativeWordCombineWriter.writerCreated == true) {
      System.out.println("Calling domain_combine constructor."); 
      new InterrogativeWordCombineWriter(); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    InterrogativeWordCombineWriter.writerCreated = var;
  }
}
