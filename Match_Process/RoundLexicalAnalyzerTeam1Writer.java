package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLexicalAnalyzerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundLexicalAnalyzerTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Parser.getFileWriter(team, round);
      RoundLexicalAnalyzerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundLexicalAnalyzerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new RoundLexicalAnalyzerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundLexicalAnalyzerTeam1Writer.writerCreated = var; 
  }
}
