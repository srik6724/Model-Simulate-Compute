package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class DomainSelectionTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  DomainSelectionTeam1Writer(String team) {
    try {
      file_writer = Domain_Selection.getFileWriter(team); 
      DomainSelectionTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static FileWriter get_file_writer() {
    if(DomainSelectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new DomainSelectionTeam1Writer("t1");
    } 
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    DomainSelectionTeam1Writer.writerCreated = var;
  }
  
}
