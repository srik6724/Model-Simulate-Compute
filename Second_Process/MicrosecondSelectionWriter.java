package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondSelectionWriter(String team, int round) {
    try {
      file_writer = Microsecond_Selection.getFileWriter(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondSelectionWriter.writerCreated == false) {
      System.out.println("Calling selection_line_writer constructor.");
      new MicrosecondSelectionWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondSelectionWriter.writerCreated = var; 
  }
}
