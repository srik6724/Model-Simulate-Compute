package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

public class ProductWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ProductWriter() {
    try {
      file_writer = Product_Finalizer.getFileWriter();
      ProductWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static FileWriter get_file_writer() {
    if(ProductWriter.writerCreated == false) {
      new ProductWriter();
    }
    return file_writer;
  }
}
