package Article_Process;

import java.io.FileReader;
import java.io.IOException;

class ArticleSelectionReader {
  private static boolean readerCreated = false;
  private static FileReader file_reader;
  
  ArticleSelectionReader(String team) {
    try {
      file_reader = Article_Selection.getFileReader(team);
      ArticleSelectionReader.readerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileReader get_file_reader(String team) {
    if(ArticleSelectionReader.readerCreated == false) {
      System.out.println("Calling domain_reader constructor.");
      new ArticleSelectionReader(team);
    }
    return file_reader;
  }

  static void setReaderCreated(boolean var) {
    ArticleSelectionReader.readerCreated = var; 
  }
}
