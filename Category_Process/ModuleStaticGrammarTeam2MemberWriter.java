package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticGrammarTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  ModuleStaticGrammarTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Fixed_Grammar.getFileWriter(team, memberNo, round);
      ModuleStaticGrammarTeam2MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleStaticGrammarTeam2MemberWriter.writerCreated == false) {
      new ModuleStaticGrammarTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticGrammarTeam2MemberWriter.writerCreated = var; 
  }
}
