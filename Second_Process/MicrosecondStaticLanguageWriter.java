package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondStaticLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondStaticLanguageWriter(String team, int round) {
    try {
      file_writer = Microsecond_Fixed_Language.getFileWriter(team, round); 
      MicrosecondStaticLanguageWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondStaticLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondStaticLanguageWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondStaticLanguageWriter.writerCreated = var; 
  }
}
