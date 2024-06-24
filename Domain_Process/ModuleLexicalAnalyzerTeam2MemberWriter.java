package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLexicalAnalyzerTeam2MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleLexicalAnalyzerTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Parser.getFileWriter(team, memberNo, round); 
      ModuleLexicalAnalyzerTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleLexicalAnalyzerTeam2MemberWriter.writerCreated == false) {
      new ModuleLexicalAnalyzerTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleLexicalAnalyzerTeam2MemberWriter.writerCreated = var; 
  }
}
