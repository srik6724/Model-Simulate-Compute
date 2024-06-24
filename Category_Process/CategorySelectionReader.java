package Category_Process;

import java.io.FileReader;
import java.io.IOException;

class CategorySelectionReader {
  private static boolean readerCreated = false;
  private static FileReader file_reader;
  
  CategorySelectionReader(String team) {
    try {
      file_reader = Category_Selection.getFileReader(team);
      CategorySelectionReader.readerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team) {
    if(CategorySelectionReader.readerCreated == false) {
      System.out.println("Calling category_reader constructor.");
      new CategorySelectionReader(team);
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    CategorySelectionReader.readerCreated = var; 
  }
}
