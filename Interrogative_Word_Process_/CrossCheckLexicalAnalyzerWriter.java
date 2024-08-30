package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLexicalAnalyzerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckLexicalAnalyzerWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Parser.getFileWriter(team, round);
      CrossCheckLexicalAnalyzerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckLexicalAnalyzerWriter.writerCreated == false) {
      System.out.println("Calling round_lexical_analyzer constructor."); 
      new CrossCheckLexicalAnalyzerTeam1Writer(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLexicalAnalyzerWriter.writerCreated = var; 
  }
}
