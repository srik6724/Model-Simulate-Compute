package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleDiscardSpellsTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  ArticleDiscardSpellsTeam1Writer(String team) {
    try {
       file_writer = Article_Discarder.getFileWriter(team);
       ArticleDiscardSpellsTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ArticleDiscardSpellsTeam1Writer.writerCreated == false) {
      System.out.println("Calling verb_discarder constructor.");
      new ArticleDiscardSpellsTeam1Writer("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleDiscardSpellsTeam1Writer.writerCreated = var; 
  }
}
