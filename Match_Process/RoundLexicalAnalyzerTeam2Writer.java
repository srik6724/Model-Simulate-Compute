package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLexicalAnalyzerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundLexicalAnalyzerTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Parser.getFileWriter(team, round);
      RoundLexicalAnalyzerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundLexicalAnalyzerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new RoundLexicalAnalyzerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundLexicalAnalyzerTeam2Writer.writerCreated = var; 
  }
}
