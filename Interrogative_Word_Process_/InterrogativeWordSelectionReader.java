package Interrogative_Word_Process_;

import java.io.FileReader;
import java.io.IOException;

class InterrogativeWordSelectionReader {
  private static boolean readerCreated = false;
  private static FileReader file_reader;
  
  InterrogativeWordSelectionReader(String team) {
    try {
      file_reader = Interrogative_Word_Selection.getFileReader(team);
      InterrogativeWordSelectionReader.readerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team) {
    if(InterrogativeWordSelectionReader.readerCreated == false) {
      System.out.println("Calling domain_reader constructor.");
      new InterrogativeWordSelectionReader(team);
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    InterrogativeWordSelectionReader.readerCreated = var; 
  }
}
