package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleSelectionTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  ArticleSelectionTeam1Writer(String team) {
    try {
      file_writer = Article_Selection.getFileWriter(team); 
      ArticleSelectionTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static FileWriter get_file_writer() {
    if(ArticleSelectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new ArticleSelectionTeam1Writer("t1");
    } 
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleSelectionTeam1Writer.writerCreated = var;
  }
  
}
