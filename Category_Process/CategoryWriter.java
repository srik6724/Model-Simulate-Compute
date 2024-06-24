package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

public class CategoryWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CategoryWriter() {
    try {
      file_writer = Category_Finalizer.getFileWriter();
      CategoryWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static FileWriter get_file_writer() {
    if(CategoryWriter.writerCreated == false) {
      new CategoryWriter();
    }
    return file_writer;
  }
}
