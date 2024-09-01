package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckSelectionWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Selection.getFileWriter(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckSelectionWriter.writerCreated == false) {
      System.out.println("Calling selection_line_writer constructor.");
      new CrossCheckSelectionWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckSelectionWriter.writerCreated = var; 
  }
}
