package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLexicalAnalyzerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondLexicalAnalyzerTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Parser.getFileWriter(team, round);
      MicrosecondLexicalAnalyzerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondLexicalAnalyzerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new MicrosecondLexicalAnalyzerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLexicalAnalyzerTeam2Writer.writerCreated = var; 
  }
}
