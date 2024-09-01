package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  VerbSelectionTeam2Writer(String team) {
    try {
      file_writer = Verb_Selection.getFileWriter(team); 
      VerbSelectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(VerbSelectionTeam2Writer.writerCreated == true) {
      System.out.println("Calling domain_selection constructor."); 
      new VerbSelectionTeam2Writer("t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbSelectionTeam2Writer.writerCreated = var; 
  }
}
