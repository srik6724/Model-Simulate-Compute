package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLexicalAnalyzerTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondLexicalAnalyzerTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Parser.getFileWriter(team, memberNo, round); 
      NanosecondLexicalAnalyzerTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondLexicalAnalyzerTeam1MemberWriter.writerCreated == false) {
      new NanosecondLexicalAnalyzerTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondLexicalAnalyzerTeam1MemberWriter.writerCreated = var; 
  }
}
