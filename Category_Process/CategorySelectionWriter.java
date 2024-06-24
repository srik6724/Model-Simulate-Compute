package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategorySelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CategorySelectionWriter(String team) {
    try {
      file_writer = Category_Selection.getFileWriter(team); 
      Category_Selection.getFileWriter(team); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CategorySelectionWriter.writerCreated == false) {
      System.out.println("Calling category_selection constructor."); 
      new CategorySelectionWriter("default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategorySelectionWriter.writerCreated = var; 
  }
}
