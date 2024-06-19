package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleChangingLanguageTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleChangingLanguageTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Dynamic_Language.getFileWriter(team, memberNo, round);
      ModuleChangingLanguageTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleChangingLanguageTeam1MemberWriter.writerCreated == false) {
      new ModuleChangingLanguageTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleChangingLanguageTeam1MemberWriter.writerCreated = var; 
  }
}
