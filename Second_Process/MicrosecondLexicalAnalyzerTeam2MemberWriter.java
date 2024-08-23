package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLexicalAnalyzerTeam2MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondLexicalAnalyzerTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Parser.getFileWriter(team, memberNo, round); 
      MicrosecondLexicalAnalyzerTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondLexicalAnalyzerTeam2MemberWriter.writerCreated == false) {
      new MicrosecondLexicalAnalyzerTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLexicalAnalyzerTeam2MemberWriter.writerCreated = var; 
  }
}
