package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbSelectionTeam1Writer {
  private static boolean writerCreated = false;
  private static FileWriter file_writer;

  VerbSelectionTeam1Writer(String team) {
    try {
      file_writer = Verb_Selection.getFileWriter(team); 
      VerbSelectionTeam1Writer.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static FileWriter get_file_writer() {
    if(VerbSelectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling domain_selection constructor."); 
      new VerbSelectionTeam1Writer("t1");
    } 
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbSelectionTeam1Writer.writerCreated = var;
  }
  
}
