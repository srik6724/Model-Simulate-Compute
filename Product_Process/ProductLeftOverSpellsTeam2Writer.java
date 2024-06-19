package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  ProductLeftOverSpellsTeam2Writer(String team) {
    try {
      file_writer = Product_Remaining.getFileWriter(team);
      ProductLeftOverSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ProductLeftOverSpellsTeam2Writer.writerCreated == true) {
      System.out.println("Calling match_remaining constructor.");
      new ProductLeftOverSpellsTeam2Writer("t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
}
