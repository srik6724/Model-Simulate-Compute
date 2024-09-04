package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticLanguageTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckStaticLanguageTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Strategy.getFileWriter(team, round); 
      CrossCheckStaticLanguageTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckStaticLanguageTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckStaticLanguageTeam1Writer("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticLanguageTeam1Writer.writerCreated = var; 
  }
}
