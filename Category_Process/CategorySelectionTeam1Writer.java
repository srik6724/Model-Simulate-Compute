package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategorySelectionTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  CategorySelectionTeam1Writer(String team) {
    try {
      file_writer = Category_Selection.getFileWriter(team); 
      CategorySelectionTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static FileWriter get_file_writer() {
    if(CategorySelectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling category_selection constructor."); 
      new CategorySelectionTeam1Writer("t1");
    } 
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategorySelectionTeam1Writer.writerCreated = var;
  }
  
}
