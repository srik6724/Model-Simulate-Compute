package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundSelectionLineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundSelectionLineWriter(String team, int round) {
    try {
      file_writer = Round_Selection_Line_Path.getFileWriter(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundSelectionLineWriter.writerCreated == false) {
      System.out.println("Calling selection_line_writer constructor.");
      new RoundSelectionLineWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundSelectionLineWriter.writerCreated = var; 
  }
}
