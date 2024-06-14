package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundChangingLanguageTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundChangingLanguageTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Dynamic_Grammar.getFileWriter(team, round);
      RoundChangingLanguageTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundChangingLanguageTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new RoundChangingLanguageTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundChangingLanguageTeam1Writer.writerCreated = var; 
  }
}
