package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundStaticGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  RoundStaticGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Fixed_Grammar.getFileWriter(team, memberNo, round);
      RoundStaticGrammarTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundStaticGrammarTeam1MemberWriter.writerCreated == false) {
      new RoundStaticGrammarTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundStaticGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
