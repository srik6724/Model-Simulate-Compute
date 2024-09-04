package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleLeftOverSpellsTeam2Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  ArticleLeftOverSpellsTeam2Writer(String team) {
    try {
      file_writer = Article_Remaining.getFileWriter(team);
      ArticleLeftOverSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ArticleLeftOverSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new ArticleLeftOverSpellsTeam2Writer("t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleLeftOverSpellsTeam2Writer.writerCreated = var; 
  }
}
