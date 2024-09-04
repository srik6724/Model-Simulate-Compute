package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ArticleDiscardSpellsWriter(String team) {
    try {
      file_writer = Article_Discarder.getFileWriter("default");
      ArticleDiscardSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ArticleDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_discarder constructor.");
      new ArticleDiscardSpellsWriter("default");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleDiscardSpellsWriter.writerCreated = var;
  }

}
