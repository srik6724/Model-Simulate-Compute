package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLexicalAnalyzerTeam2MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckLexicalAnalyzerTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Parser.getFileWriter(team, memberNo, round); 
      CrossCheckLexicalAnalyzerTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckLexicalAnalyzerTeam2MemberWriter.writerCreated == false) {
      new CrossCheckLexicalAnalyzerTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLexicalAnalyzerTeam2MemberWriter.writerCreated = var; 
  }
}
