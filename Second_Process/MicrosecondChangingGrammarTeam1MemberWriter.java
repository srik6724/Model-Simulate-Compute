package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondChangingGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondChangingGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Dynamic_Grammar.getFileWriter(team, memberNo, round); 
      MicrosecondChangingGrammarTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondChangingGrammarTeam1MemberWriter.writerCreated == false) {
      new MicrosecondChangingGrammarTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondChangingGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
