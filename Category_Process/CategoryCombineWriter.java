package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategoryCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;
  
  CategoryCombineWriter() {
    try {
      file_writer = Category_Merge_Finalizer.getFileWriter(); 
      CategoryCombineWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CategoryCombineWriter.writerCreated == true) {
      System.out.println("Calling category_combine constructor."); 
      new CategoryCombineWriter(); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategoryCombineWriter.writerCreated = var;
  }
}
