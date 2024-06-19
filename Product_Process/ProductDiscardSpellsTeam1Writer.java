package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ProductDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  ProductDiscardSpellsTeam1Writer(String team) {
    try {
       file_writer = Product_Discarder.getFileWriter(team);
       ProductDiscardSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ProductDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling match_discarder constructor.");
      new ProductDiscardSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ProductDiscardSpellsTeam1Writer.writerCreated = var; 
  }
}
