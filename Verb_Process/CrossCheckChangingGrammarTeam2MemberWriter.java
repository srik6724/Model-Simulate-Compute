package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckChangingGrammarTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckChangingGrammarTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Dynamic_Grammar.getFileWriter(team, memberNo, round); 
      CrossCheckChangingGrammarTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckChangingGrammarTeam2MemberWriter.writerCreated == false) {
      new CrossCheckChangingGrammarTeam2MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckChangingGrammarTeam2MemberWriter.writerCreated = var; 
  }
}
