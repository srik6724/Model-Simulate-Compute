package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  CrossCheckStaticGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Fixed_Grammar.getFileWriter(team, memberNo, round);
      CrossCheckStaticGrammarTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckStaticGrammarTeam1MemberWriter.writerCreated == false) {
      new CrossCheckStaticGrammarTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
