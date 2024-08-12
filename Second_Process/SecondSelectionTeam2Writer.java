package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class SecondSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  SecondSelectionTeam2Writer(String team) {
    try {
      file_writer = Second_Selection.getFileWriter(team); 
      SecondSelectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(SecondSelectionTeam2Writer.writerCreated == true) {
      System.out.println("Calling domain_selection constructor."); 
      new SecondSelectionTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SecondSelectionTeam2Writer.writerCreated = var; 
  }
}
