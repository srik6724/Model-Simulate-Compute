package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLexicalAnalyzerTeam2MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundLexicalAnalyzerTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Parser.getFileWriter(team, memberNo, round); 
      RoundLexicalAnalyzerTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundLexicalAnalyzerTeam2MemberWriter.writerCreated == false) {
      new RoundLexicalAnalyzerTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundLexicalAnalyzerTeam2MemberWriter.writerCreated = var; 
  }
}
