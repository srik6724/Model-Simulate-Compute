package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLexicalAnalyzerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundLexicalAnalyzerWriter(int round, String team) {
    try {
      file_writer = Round_Parser.getFileWriter(team, round);
      RoundLexicalAnalyzerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundLexicalAnalyzerWriter.writerCreated == false) {
      System.out.println("Calling round_lexical_analyzer constructor."); 
      new RoundLexicalAnalyzerTeam1Writer(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundLexicalAnalyzerWriter.writerCreated = var; 
  }
}
