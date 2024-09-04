package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ArticleSelectionTeam2Writer(String team) {
    try {
      file_writer = Article_Selection.getFileWriter(team); 
      ArticleSelectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ArticleSelectionTeam2Writer.writerCreated == true) {
      System.out.println("Calling domain_selection constructor."); 
      new ArticleSelectionTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleSelectionTeam2Writer.writerCreated = var; 
  }
}
