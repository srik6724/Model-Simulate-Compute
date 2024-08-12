package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondStaticGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  NanosecondStaticGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Fixed_Grammar.getFileWriter(team, memberNo, round);
      NanosecondStaticGrammarTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondStaticGrammarTeam1MemberWriter.writerCreated == false) {
      new NanosecondStaticGrammarTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondStaticGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
