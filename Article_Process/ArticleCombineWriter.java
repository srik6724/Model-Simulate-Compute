package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;
  
  ArticleCombineWriter() {
    try {
      file_writer = Article_Merge_Finalizer.getFileWriter(); 
      ArticleCombineWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ArticleCombineWriter.writerCreated == true) {
      System.out.println("Calling domain_combine constructor."); 
      new ArticleCombineWriter(); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleCombineWriter.writerCreated = var;
  }
}
