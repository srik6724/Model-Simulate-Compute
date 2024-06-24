package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ProductDiscardSpellsWriter(String team) {
    try {
      file_writer = Product_Discarder.getFileWriter("default");
      ProductDiscardSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ProductDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new ProductDiscardSpellsWriter("default");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductDiscardSpellsWriter.writerCreated = var;
  }

}
