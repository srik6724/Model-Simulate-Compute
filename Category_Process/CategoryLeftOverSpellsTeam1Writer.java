package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategoryLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer; 

  CategoryLeftOverSpellsTeam1Writer(String team) {
    try {
      file_writer = Category_Remaining.getFileWriter(team);
      CategoryLeftOverSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CategoryLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling category_remaining constructor.");
      new CategoryLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategoryLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
}
