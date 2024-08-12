package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondStaticLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondStaticLanguageWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Strategy.getFileWriter(team, round); 
      NanosecondStaticLanguageWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondStaticLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondStaticLanguageWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondStaticLanguageWriter.writerCreated = var; 
  }
}
