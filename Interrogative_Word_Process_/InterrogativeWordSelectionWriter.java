package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class InterrogativeWordSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  InterrogativeWordSelectionWriter(String team) {
    try {
      file_writer = Interrogative_Word_Selection.getFileWriter(team); 
      Interrogative_Word_Selection.getFileWriter(team); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(InterrogativeWordSelectionWriter.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new InterrogativeWordSelectionWriter("default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    InterrogativeWordSelectionWriter.writerCreated = var; 
  }
}
