package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticGrammarTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  CrossCheckStaticGrammarTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Fixed_Grammar.getFileWriter(team, memberNo, round);
      CrossCheckStaticGrammarTeam2MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckStaticGrammarTeam2MemberWriter.writerCreated == false) {
      new CrossCheckStaticGrammarTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticGrammarTeam2MemberWriter.writerCreated = var; 
  }
}
