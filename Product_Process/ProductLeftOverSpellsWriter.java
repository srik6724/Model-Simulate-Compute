package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ProductLeftOverSpellsWriter(String team) {
    try {
      file_writer = Product_Remaining.getFileWriter(team); 
      ProductLeftOverSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ProductLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new ProductLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductLeftOverSpellsWriter.writerCreated = var; 
  }
}
