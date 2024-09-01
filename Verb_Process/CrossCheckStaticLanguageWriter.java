package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckStaticLanguageWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Strategy.getFileWriter(team, round); 
      CrossCheckStaticLanguageWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckStaticLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckStaticLanguageWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticLanguageWriter.writerCreated = var; 
  }
}
