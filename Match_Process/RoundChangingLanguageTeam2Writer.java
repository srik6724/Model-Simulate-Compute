package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundChangingLanguageTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundChangingLanguageTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Dynamic_Grammar.getFileWriter(team, round);
      RoundChangingLanguageTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundChangingLanguageTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new RoundChangingLanguageTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundChangingLanguageTeam2Writer.writerCreated = var; 
  }
}
