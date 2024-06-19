package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ProductSelectionTeam2Writer(String team) {
    try {
      file_writer = Product_Selection.getFileWriter(team); 
      ProductSelectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ProductSelectionTeam2Writer.writerCreated == true) {
      System.out.println("Calling match_selection constructor."); 
      new ProductSelectionTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductSelectionTeam2Writer.writerCreated = var; 
  }
}
