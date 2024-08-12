package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class SecondCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;
  
  SecondCombineWriter() {
    try {
      file_writer = Second_Merge_Finalizer.getFileWriter(); 
      SecondCombineWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(SecondCombineWriter.writerCreated == true) {
      System.out.println("Calling domain_combine constructor."); 
      new SecondCombineWriter(); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SecondCombineWriter.writerCreated = var;
  }
}
