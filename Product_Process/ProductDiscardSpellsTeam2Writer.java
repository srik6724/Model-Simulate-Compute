package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ProductDiscardSpellsTeam2Writer(String team) {
    try {
      file_writer = Product_Discarder.getFileWriter(team);
      ProductDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ProductDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling match_discarder constructor.");
      new ProductDiscardSpellsTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
