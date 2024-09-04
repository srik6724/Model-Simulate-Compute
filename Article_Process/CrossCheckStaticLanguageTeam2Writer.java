package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticLanguageTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckStaticLanguageTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Strategy.getFileWriter(team, round); 
      CrossCheckStaticLanguageTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckStaticLanguageTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckStaticLanguageTeam2Writer("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticLanguageTeam2Writer.writerCreated = var; 
  }
}
