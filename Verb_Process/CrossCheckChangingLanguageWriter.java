package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckChangingLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckChangingLanguageWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Dynamic_Language.getFileWriter(team, round);
      CrossCheckChangingLanguageWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckChangingLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new CrossCheckChangingLanguageWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckChangingLanguageWriter.writerCreated = var; 
  }
}
