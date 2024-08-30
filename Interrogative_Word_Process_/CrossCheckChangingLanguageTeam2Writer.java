package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckChangingLanguageTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckChangingLanguageTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Dynamic_Grammar.getFileWriter(team, round);
      CrossCheckChangingLanguageTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckChangingLanguageTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new CrossCheckChangingLanguageTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckChangingLanguageTeam2Writer.writerCreated = var; 
  }
}
