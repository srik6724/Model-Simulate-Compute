package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondStaticGrammarTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  MicrosecondStaticGrammarTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Fixed_Grammar.getFileWriter(team, memberNo, round);
      MicrosecondStaticGrammarTeam2MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondStaticGrammarTeam2MemberWriter.writerCreated == false) {
      new MicrosecondStaticGrammarTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondStaticGrammarTeam2MemberWriter.writerCreated = var; 
  }
}
