package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundStaticLanguageTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundStaticLanguageTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Strategy.getFileWriter(team, round); 
      RoundStaticLanguageTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundStaticLanguageTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundStaticLanguageTeam2Writer("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundStaticLanguageTeam2Writer.writerCreated = var; 
  }
}
