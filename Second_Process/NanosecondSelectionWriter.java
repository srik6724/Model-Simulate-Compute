package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondSelectionWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Selection.getFileWriter(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondSelectionWriter.writerCreated == false) {
      System.out.println("Calling selection_line_writer constructor.");
      new NanosecondSelectionWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondSelectionWriter.writerCreated = var; 
  }
}
