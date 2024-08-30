package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class InterrogativeWordSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  InterrogativeWordSelectionTeam2Writer(String team) {
    try {
      file_writer = Interrogative_Word_Selection.getFileWriter(team); 
      InterrogativeWordSelectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(InterrogativeWordSelectionTeam2Writer.writerCreated == true) {
      System.out.println("Calling domain_selection constructor."); 
      new InterrogativeWordSelectionTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    InterrogativeWordSelectionTeam2Writer.writerCreated = var; 
  }
}
