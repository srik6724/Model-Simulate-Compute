package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLexicalAnalyzerTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleLexicalAnalyzerTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Parser.getFileWriter(team, memberNo, round); 
      ModuleLexicalAnalyzerTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleLexicalAnalyzerTeam1MemberWriter.writerCreated == false) {
      new ModuleLexicalAnalyzerTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleLexicalAnalyzerTeam1MemberWriter.writerCreated = var; 
  }
}
