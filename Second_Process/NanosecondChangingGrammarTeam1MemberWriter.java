package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondChangingGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondChangingGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Dynamic_Grammar.getFileWriter(team, memberNo, round); 
      NanosecondChangingGrammarTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondChangingGrammarTeam1MemberWriter.writerCreated == false) {
      new NanosecondChangingGrammarTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondChangingGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
