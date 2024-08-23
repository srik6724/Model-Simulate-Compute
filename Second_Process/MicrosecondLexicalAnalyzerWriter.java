package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLexicalAnalyzerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondLexicalAnalyzerWriter(int round, String team) {
    try {
      file_writer = Microsecond_Parser.getFileWriter(team, round);
      MicrosecondLexicalAnalyzerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondLexicalAnalyzerWriter.writerCreated == false) {
      System.out.println("Calling round_lexical_analyzer constructor."); 
      new MicrosecondLexicalAnalyzerTeam1Writer(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLexicalAnalyzerWriter.writerCreated = var; 
  }
}
