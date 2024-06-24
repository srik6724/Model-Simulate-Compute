package Product_Process;


import java.io.FileReader;
import java.io.IOException;

class ModuleSelectionReader {
  private static boolean readerCreated = false; 
  private static FileReader file_reader; 

  ModuleSelectionReader(String team, int round) {
    try {
      file_reader = Module_Selection.getFileReader(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team, int round) {
    if(ModuleSelectionReader.readerCreated == false) {
      System.out.println("Calling selection_line reader constructor."); 
      new ModuleSelectionReader(team, round); 
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    ModuleSelectionReader.readerCreated = var; 
  }
}
