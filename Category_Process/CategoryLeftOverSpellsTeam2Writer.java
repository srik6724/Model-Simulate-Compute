package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategoryLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  CategoryLeftOverSpellsTeam2Writer(String team) {
    try {
      file_writer = Category_Remaining.getFileWriter(team);
      CategoryLeftOverSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CategoryLeftOverSpellsTeam2Writer.writerCreated == true) {
      System.out.println("Calling category_remaining constructor.");
      new CategoryLeftOverSpellsTeam2Writer("t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategoryLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
}
