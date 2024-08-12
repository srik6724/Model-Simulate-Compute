package Second_Process;

import java.io.FileReader;
import java.io.IOException;

class SecondSelectionReader {
  private static boolean readerCreated = false;
  private static FileReader file_reader;
  
  SecondSelectionReader(String team) {
    try {
      file_reader = Second_Selection.getFileReader(team);
      SecondSelectionReader.readerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team) {
    if(SecondSelectionReader.readerCreated == false) {
      System.out.println("Calling domain_reader constructor.");
      new SecondSelectionReader(team);
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    SecondSelectionReader.readerCreated = var; 
  }
}
