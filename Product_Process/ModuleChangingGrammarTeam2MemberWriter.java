package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleChangingGrammarTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleChangingGrammarTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Dynamic_Grammar.getFileWriter(team, memberNo, round); 
      ModuleChangingGrammarTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleChangingGrammarTeam2MemberWriter.writerCreated == false) {
      new ModuleChangingGrammarTeam2MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleChangingGrammarTeam2MemberWriter.writerCreated = var; 
  }
}
