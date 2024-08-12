package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLexicalAnalyzerTeam2MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondLexicalAnalyzerTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Parser.getFileWriter(team, memberNo, round); 
      NanosecondLexicalAnalyzerTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondLexicalAnalyzerTeam2MemberWriter.writerCreated == false) {
      new NanosecondLexicalAnalyzerTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondLexicalAnalyzerTeam2MemberWriter.writerCreated = var; 
  }
}
