package Verb_Process;

import java.io.FileReader;
import java.io.IOException;

class VerbSelectionReader {
  private static boolean readerCreated = false;
  private static FileReader file_reader;
  
  VerbSelectionReader(String team) {
    try {
      file_reader = Verb_Selection.getFileReader(team);
      VerbSelectionReader.readerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team) {
    if(VerbSelectionReader.readerCreated == false) {
      System.out.println("Calling domain_reader constructor.");
      new VerbSelectionReader(team);
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    VerbSelectionReader.readerCreated = var; 
  }
}
