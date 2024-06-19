package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer; 

  ProductLeftOverSpellsTeam1Writer(String team) {
    try {
      file_writer = Product_Remaining.getFileWriter(team);
      ProductLeftOverSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ProductLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling match_remaining constructor.");
      new ProductLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
}
