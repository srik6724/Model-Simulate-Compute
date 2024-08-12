package Second_Process;


import java.io.FileReader;
import java.io.IOException;

class NanosecondSelectionReader {
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 

  NanosecondSelectionReader(String team, int round) {
    try {
      file_reader = Nanosecond_Selection.getFileReader(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team, int round) {
    if(NanosecondSelectionReader.readerCreated == false) {
      System.out.println("Calling selection_line reader constructor."); 
      new NanosecondSelectionReader(team, round); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    NanosecondSelectionReader.readerCreated = var; 
  }
}
