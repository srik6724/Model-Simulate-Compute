package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class MatchDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  MatchDiscardSpellsWriter(String team) {
    try {
      file_writer = Match_Discarder.getFileWriter("default");
      MatchDiscardSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling match_discarder constructor.");
      new MatchDiscardSpellsWriter("default");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchDiscardSpellsWriter.writerCreated = var;
  }

}
