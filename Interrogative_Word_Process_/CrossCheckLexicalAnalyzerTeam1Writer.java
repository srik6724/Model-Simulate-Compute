package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLexicalAnalyzerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckLexicalAnalyzerTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Parser.getFileWriter(team, round);
      CrossCheckLexicalAnalyzerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckLexicalAnalyzerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new CrossCheckLexicalAnalyzerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLexicalAnalyzerTeam1Writer.writerCreated = var; 
  }
}
