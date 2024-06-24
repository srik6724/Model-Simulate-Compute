package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;
  
  DomainCombineWriter() {
    try {
      file_writer = Domain_Merge_Finalizer.getFileWriter(); 
      DomainCombineWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(DomainCombineWriter.writerCreated == true) {
      System.out.println("Calling domain_combine constructor."); 
      new DomainCombineWriter(); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainCombineWriter.writerCreated = var;
  }
}
