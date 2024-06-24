package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class CategoryDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CategoryDiscardSpellsTeam2Writer(String team) {
    try {
      file_writer = Category_Discarder.getFileWriter(team);
      CategoryDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(CategoryDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling category_discarder constructor.");
      new CategoryDiscardSpellsTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CategoryDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
