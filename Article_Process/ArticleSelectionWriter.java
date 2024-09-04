package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ArticleSelectionWriter(String team) {
    try {
      file_writer = Article_Selection.getFileWriter(team); 
      Article_Selection.getFileWriter(team); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ArticleSelectionWriter.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new ArticleSelectionWriter("default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleSelectionWriter.writerCreated = var; 
  }
}
