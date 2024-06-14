package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundChangingLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundChangingLanguageWriter(String team, int round) {
    try {
      file_writer = Round_Dynamic_Language.getFileWriter(team, round);
      RoundChangingLanguageWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundChangingLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new RoundChangingLanguageWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundChangingLanguageWriter.writerCreated = var; 
  }
}
