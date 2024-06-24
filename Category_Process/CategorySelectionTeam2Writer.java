package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategorySelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CategorySelectionTeam2Writer(String team) {
    try {
      file_writer = Category_Selection.getFileWriter(team); 
      CategorySelectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CategorySelectionTeam2Writer.writerCreated == true) {
      System.out.println("Calling category_selection constructor."); 
      new CategorySelectionTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategorySelectionTeam2Writer.writerCreated = var; 
  }
}
