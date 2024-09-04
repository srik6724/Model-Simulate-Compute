package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleLeftOverSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer; 

  ArticleLeftOverSpellsTeam1Writer(String team) {
    try {
      file_writer = Article_Remaining.getFileWriter(team);
      ArticleLeftOverSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ArticleLeftOverSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new ArticleLeftOverSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleLeftOverSpellsTeam1Writer.writerCreated = var; 
  }
}
