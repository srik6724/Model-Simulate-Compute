package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ArticleLeftOverSpellsWriter(String team) {
    try {
      file_writer = Article_Remaining.getFileWriter(team); 
      ArticleLeftOverSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ArticleLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new ArticleLeftOverSpellsWriter("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleLeftOverSpellsWriter.writerCreated = var; 
  }
}
