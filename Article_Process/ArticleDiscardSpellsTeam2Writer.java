package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class ArticleDiscardSpellsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ArticleDiscardSpellsTeam2Writer(String team) {
    try {
      file_writer = Article_Discarder.getFileWriter(team);
      ArticleDiscardSpellsTeam2Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ArticleDiscardSpellsTeam2Writer.writerCreated == false) {
      System.out.println("Calling verb_discarder constructor.");
      new ArticleDiscardSpellsTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ArticleDiscardSpellsTeam2Writer.writerCreated = var;
  }
}
