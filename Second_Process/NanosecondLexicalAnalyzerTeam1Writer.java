package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLexicalAnalyzerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondLexicalAnalyzerTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Parser.getFileWriter(team, round);
      NanosecondLexicalAnalyzerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondLexicalAnalyzerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new NanosecondLexicalAnalyzerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondLexicalAnalyzerTeam1Writer.writerCreated = var; 
  }
}
