package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbSelectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  VerbSelectionWriter(String team) {
    try {
      file_writer = Verb_Selection.getFileWriter(team); 
      Verb_Selection.getFileWriter(team); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(VerbSelectionWriter.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new VerbSelectionWriter("default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbSelectionWriter.writerCreated = var; 
  }
}
