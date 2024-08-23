package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondChangingGrammarTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondChangingGrammarTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Dynamic_Grammar.getFileWriter(team, memberNo, round); 
      MicrosecondChangingGrammarTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondChangingGrammarTeam2MemberWriter.writerCreated == false) {
      new MicrosecondChangingGrammarTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondChangingGrammarTeam2MemberWriter.writerCreated = var; 
  }
}
