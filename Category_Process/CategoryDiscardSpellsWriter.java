package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategoryDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  CategoryDiscardSpellsWriter(String team) {
    try {
      file_writer = Category_Discarder.getFileWriter("default");
      CategoryDiscardSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CategoryDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling category_discarder constructor.");
      new CategoryDiscardSpellsWriter("default");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategoryDiscardSpellsWriter.writerCreated = var;
  }

}
