package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundStaticGrammarTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  RoundStaticGrammarTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Fixed_Grammar.getFileWriter(team, memberNo, round);
      RoundStaticGrammarTeam2MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundStaticGrammarTeam2MemberWriter.writerCreated == false) {
      new RoundStaticGrammarTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundStaticGrammarTeam2MemberWriter.writerCreated = var; 
  }
}