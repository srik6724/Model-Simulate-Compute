package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondStaticLanguageTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondStaticLanguageTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Fixed_Language.getFileWriter(team, round); 
      MicrosecondStaticLanguageTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondStaticLanguageTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondStaticLanguageTeam1Writer("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondStaticLanguageTeam1Writer.writerCreated = var; 
  }
}
