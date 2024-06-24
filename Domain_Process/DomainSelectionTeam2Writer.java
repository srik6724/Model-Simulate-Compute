package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  DomainSelectionTeam2Writer(String team) {
    try {
      file_writer = Domain_Selection.getFileWriter(team); 
      DomainSelectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(DomainSelectionTeam2Writer.writerCreated == true) {
      System.out.println("Calling domain_selection constructor."); 
      new DomainSelectionTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainSelectionTeam2Writer.writerCreated = var; 
  }
}
