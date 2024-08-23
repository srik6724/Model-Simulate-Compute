package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondStaticGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  MicrosecondStaticGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Fixed_Grammar.getFileWriter(team, memberNo, round);
      MicrosecondStaticGrammarTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondStaticGrammarTeam1MemberWriter.writerCreated == false) {
      new MicrosecondStaticGrammarTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondStaticGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
