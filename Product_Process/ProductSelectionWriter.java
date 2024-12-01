package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ProductSelectionWriter(String team) {
    try {
      file_writer = Product_Selection.getFileWriter(team); 
      Product_Selection.getFileWriter(team); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ProductSelectionWriter.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new ProductSelectionWriter("default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductSelectionWriter.writerCreated = var; 
  }
}
