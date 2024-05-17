package wizPackage;


import java.io.FileReader;
import java.io.IOException;

class SelectionLineReader {
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 

  SelectionLineReader(String team, int round) {
    try {
      file_reader = Selection_Line_Path.getFileReader(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team, int round) {
    if(SelectionLineReader.readerCreated == false) {
      System.out.println("Calling selection_line reader constructor."); 
      new SelectionLineReader(team, round); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    SelectionLineReader.readerCreated = var; 
  }
}
