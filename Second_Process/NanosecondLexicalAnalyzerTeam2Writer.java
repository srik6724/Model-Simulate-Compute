package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLexicalAnalyzerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondLexicalAnalyzerTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Parser.getFileWriter(team, round);
      NanosecondLexicalAnalyzerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondLexicalAnalyzerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new NanosecondLexicalAnalyzerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondLexicalAnalyzerTeam2Writer.writerCreated = var; 
  }
}
