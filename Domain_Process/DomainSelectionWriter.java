package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  DomainSelectionWriter(String team) {
    try {
      file_writer = Domain_Selection.getFileWriter(team); 
      Domain_Selection.getFileWriter(team); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(DomainSelectionWriter.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new DomainSelectionWriter("default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainSelectionWriter.writerCreated = var; 
  }
}
