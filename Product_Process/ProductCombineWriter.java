package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;
  
  ProductCombineWriter() {
    try {
      file_writer = Product_Merge_Finalizer.getFileWriter(); 
      ProductCombineWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ProductCombineWriter.writerCreated == true) {
      System.out.println("Calling domain_combine constructor."); 
      new ProductCombineWriter(); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductCombineWriter.writerCreated = var;
  }
}
