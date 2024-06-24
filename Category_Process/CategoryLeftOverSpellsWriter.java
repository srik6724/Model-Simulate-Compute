package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategoryLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  CategoryLeftOverSpellsWriter(String team) {
    try {
      file_writer = Category_Remaining.getFileWriter(team); 
      CategoryLeftOverSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CategoryLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling category_remaining constructor.");
      new CategoryLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategoryLeftOverSpellsWriter.writerCreated = var; 
  }
}
