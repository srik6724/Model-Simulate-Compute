package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticGrammarTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  ModuleStaticGrammarTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Fixed_Grammar.getFileWriter(team, memberNo, round);
      ModuleStaticGrammarTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleStaticGrammarTeam1MemberWriter.writerCreated == false) {
      new ModuleStaticGrammarTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticGrammarTeam1MemberWriter.writerCreated = var; 
  }
}
