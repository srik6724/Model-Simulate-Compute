package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductSelectionTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  ProductSelectionTeam1Writer(String team) {
    try {
      file_writer = Second_Selection.getFileWriter(team); 
      ProductSelectionTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static FileWriter get_file_writer() {
    if(ProductSelectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new ProductSelectionTeam1Writer("t1");
    } 
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductSelectionTeam1Writer.writerCreated = var;
  }
  
}
