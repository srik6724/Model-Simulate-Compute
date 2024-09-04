package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLexicalAnalyzerTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckLexicalAnalyzerTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Parser.getFileWriter(team, memberNo, round); 
      CrossCheckLexicalAnalyzerTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckLexicalAnalyzerTeam1MemberWriter.writerCreated == false) {
      new CrossCheckLexicalAnalyzerTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLexicalAnalyzerTeam1MemberWriter.writerCreated = var; 
  }
}
