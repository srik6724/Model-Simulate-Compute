package Domain_Process;

import java.io.FileReader;
import java.io.IOException;

class DomainSelectionReader {
  private static boolean readerCreated = false;
  private static FileReader file_reader;
  
  DomainSelectionReader(String team) {
    try {
      file_reader = Domain_Selection.getFileReader(team);
      DomainSelectionReader.readerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team) {
    if(DomainSelectionReader.readerCreated == false) {
      System.out.println("Calling domain_reader constructor.");
      new DomainSelectionReader(team);
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    DomainSelectionReader.readerCreated = var; 
  }
}
