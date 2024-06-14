package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundChangingGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundChangingGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Dynamic_Grammar.getFileWriter(team, memberNo, round); 
      RoundChangingGrammarTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundChangingGrammarTeam1MemberWriter.writerCreated == false) {
      new RoundChangingGrammarTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundChangingGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
