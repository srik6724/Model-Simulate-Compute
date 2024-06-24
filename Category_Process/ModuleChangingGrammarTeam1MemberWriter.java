package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleChangingGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleChangingGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Dynamic_Grammar.getFileWriter(team, memberNo, round); 
      ModuleChangingGrammarTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleChangingGrammarTeam1MemberWriter.writerCreated == false) {
      new ModuleChangingGrammarTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleChangingGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
