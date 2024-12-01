package Product_Process;

import java.io.FileReader;
import java.io.IOException;

class ProductSelectionReader {
  private static boolean readerCreated = false;
  private static FileReader file_reader;
  
  ProductSelectionReader(String team) {
    try {
      file_reader = Product_Selection.getFileReader(team);
      ProductSelectionReader.readerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team) {
    if(ProductSelectionReader.readerCreated == false) {
      System.out.println("Calling domain_reader constructor.");
      new ProductSelectionReader(team);
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    ProductSelectionReader.readerCreated = var; 
  }
}
