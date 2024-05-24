package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class MatchSelectionLineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MatchSelectionLineWriter(String team) {
    try {
      file_writer = Match_Selection_Line_Path.getFileWriter(team); 
      Match_Selection_Line_Path.getFileWriter(team); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchSelectionLineWriter.writerCreated == false) {
      System.out.println("Calling match_selection constructor."); 
      new MatchSelectionLineWriter("default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchSelectionLineWriter.writerCreated = var; 
  }
}
