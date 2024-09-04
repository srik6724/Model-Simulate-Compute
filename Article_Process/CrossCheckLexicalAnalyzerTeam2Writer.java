package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLexicalAnalyzerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckLexicalAnalyzerTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Parser.getFileWriter(team, round);
      CrossCheckLexicalAnalyzerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckLexicalAnalyzerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new CrossCheckLexicalAnalyzerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLexicalAnalyzerTeam2Writer.writerCreated = var; 
  }
}
