package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondStaticLanguageTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondStaticLanguageTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Strategy.getFileWriter(team, round); 
      NanosecondStaticLanguageTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondStaticLanguageTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondStaticLanguageTeam1Writer("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondStaticLanguageTeam1Writer.writerCreated = var; 
  }
}
