package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundSelectionWriter(String team, int round) {
    try {
      file_writer = Round_Selection.getFileWriter(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundSelectionWriter.writerCreated == false) {
      System.out.println("Calling selection_line_writer constructor.");
      new RoundSelectionWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundSelectionWriter.writerCreated = var; 
  }
}
