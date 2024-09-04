package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckChangingLanguageTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckChangingLanguageTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Dynamic_Grammar.getFileWriter(team, round);
      CrossCheckChangingLanguageTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckChangingLanguageTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new CrossCheckChangingLanguageTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckChangingLanguageTeam1Writer.writerCreated = var; 
  }
}
