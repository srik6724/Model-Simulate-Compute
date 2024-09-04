package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckChangingGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckChangingGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Dynamic_Grammar.getFileWriter(team, memberNo, round); 
      CrossCheckChangingGrammarTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckChangingGrammarTeam1MemberWriter.writerCreated == false) {
      new CrossCheckChangingGrammarTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckChangingGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
