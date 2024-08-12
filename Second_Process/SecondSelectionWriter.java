package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class SecondSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  SecondSelectionWriter(String team) {
    try {
      file_writer = Second_Selection.getFileWriter(team); 
      Second_Selection.getFileWriter(team); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(SecondSelectionWriter.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new SecondSelectionWriter("default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SecondSelectionWriter.writerCreated = var; 
  }
}
