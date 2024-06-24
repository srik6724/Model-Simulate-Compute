package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

public class DomainWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  DomainWriter() {
    try {
      file_writer = Domain_Finalizer.getFileWriter();
      DomainWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static FileWriter get_file_writer() {
    if(DomainWriter.writerCreated == false) {
      new DomainWriter();
    }
    return file_writer;
  }
}
