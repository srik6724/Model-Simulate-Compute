package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondChangingGrammarTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondChangingGrammarTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Dynamic_Grammar.getFileWriter(team, memberNo, round); 
      NanosecondChangingGrammarTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondChangingGrammarTeam2MemberWriter.writerCreated == false) {
      new NanosecondChangingGrammarTeam2MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondChangingGrammarTeam2MemberWriter.writerCreated = var; 
  }
}
