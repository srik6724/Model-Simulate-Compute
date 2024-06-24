package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticLanguageTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  ModuleStaticLanguageTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Fixed_Language.getFileWriter(team, memberNo, round); 
      ModuleStaticLanguageTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleStaticLanguageTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleStaticLanguageTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticLanguageTeam1MemberWriter.writerCreated = var; 
  }
}
