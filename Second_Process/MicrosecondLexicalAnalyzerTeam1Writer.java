package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLexicalAnalyzerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondLexicalAnalyzerTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Parser.getFileWriter(team, round);
      MicrosecondLexicalAnalyzerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondLexicalAnalyzerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new MicrosecondLexicalAnalyzerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLexicalAnalyzerTeam1Writer.writerCreated = var; 
  }
}
