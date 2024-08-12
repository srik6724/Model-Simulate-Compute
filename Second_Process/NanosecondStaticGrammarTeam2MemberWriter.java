package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondStaticGrammarTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  NanosecondStaticGrammarTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Fixed_Grammar.getFileWriter(team, memberNo, round);
      NanosecondStaticGrammarTeam2MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondStaticGrammarTeam2MemberWriter.writerCreated == false) {
      new NanosecondStaticGrammarTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondStaticGrammarTeam2MemberWriter.writerCreated = var; 
  }
}
