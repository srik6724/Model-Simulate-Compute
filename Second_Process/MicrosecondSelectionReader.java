package Second_Process;


import java.io.FileReader;
import java.io.IOException;

class MicrosecondSelectionReader {
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 

  MicrosecondSelectionReader(String team, int round) {
    try {
      file_reader = Microsecond_Selection.getFileReader(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team, int round) {
    if(MicrosecondSelectionReader.readerCreated == false) {
      System.out.println("Calling selection_line reader constructor."); 
      new MicrosecondSelectionReader(team, round); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    MicrosecondSelectionReader.readerCreated = var; 
  }
}
