package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

public class ArticleWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ArticleWriter() {
    try {
      file_writer = Article_Finalizer.getFileWriter();
      ArticleWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static FileWriter get_file_writer() {
    if(ArticleWriter.writerCreated == false) {
      new ArticleWriter();
    }
    return file_writer;
  }
}
