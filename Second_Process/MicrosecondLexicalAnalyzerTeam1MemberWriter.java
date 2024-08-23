package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLexicalAnalyzerTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondLexicalAnalyzerTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Parser.getFileWriter(team, memberNo, round); 
      MicrosecondLexicalAnalyzerTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondLexicalAnalyzerTeam1MemberWriter.writerCreated == false) {
      new MicrosecondLexicalAnalyzerTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLexicalAnalyzerTeam1MemberWriter.writerCreated = var; 
  }
}
