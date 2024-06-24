package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategoryDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  CategoryDiscardSpellsTeam1Writer(String team) {
    try {
       file_writer = Category_Discarder.getFileWriter(team);
       CategoryDiscardSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CategoryDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling category_discarder constructor.");
      new CategoryDiscardSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategoryDiscardSpellsTeam1Writer.writerCreated = var; 
  }
}
