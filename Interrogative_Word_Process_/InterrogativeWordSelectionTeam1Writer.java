package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class InterrogativeWordSelectionTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  InterrogativeWordSelectionTeam1Writer(String team) {
    try {
      file_writer = Interrogative_Word_Selection.getFileWriter(team); 
      InterrogativeWordSelectionTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static FileWriter get_file_writer() {
    if(InterrogativeWordSelectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new InterrogativeWordSelectionTeam1Writer("t1");
    } 
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    InterrogativeWordSelectionTeam1Writer.writerCreated = var;
  }
  
}
