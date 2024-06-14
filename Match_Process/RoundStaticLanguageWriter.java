package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundStaticLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundStaticLanguageWriter(String team, int round) {
    try {
      file_writer = Round_Strategy.getFileWriter(team, round); 
      RoundStaticLanguageWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundStaticLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundStaticLanguageWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundStaticLanguageWriter.writerCreated = var; 
  }
}
