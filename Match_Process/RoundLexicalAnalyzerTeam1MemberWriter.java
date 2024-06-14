package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLexicalAnalyzerTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundLexicalAnalyzerTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Parser.getFileWriter(team, memberNo, round); 
      RoundLexicalAnalyzerTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundLexicalAnalyzerTeam1MemberWriter.writerCreated == false) {
      new RoundLexicalAnalyzerTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundLexicalAnalyzerTeam1MemberWriter.writerCreated = var; 
  }
}
