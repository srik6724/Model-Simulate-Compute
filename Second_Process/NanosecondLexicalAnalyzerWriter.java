package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLexicalAnalyzerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondLexicalAnalyzerWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Parser.getFileWriter(team, round);
      NanosecondLexicalAnalyzerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondLexicalAnalyzerWriter.writerCreated == false) {
      System.out.println("Calling round_lexical_analyzer constructor."); 
      new NanosecondLexicalAnalyzerTeam1Writer(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondLexicalAnalyzerWriter.writerCreated = var; 
  }
}
