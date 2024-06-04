package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class MatchSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MatchSelectionWriter(String team) {
    try {
      file_writer = Match_Selection.getFileWriter(team); 
      Match_Selection.getFileWriter(team); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchSelectionWriter.writerCreated == false) {
      System.out.println("Calling match_selection constructor."); 
      new MatchSelectionWriter("default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchSelectionWriter.writerCreated = var; 
  }
}
