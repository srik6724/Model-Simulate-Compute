package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticLanguageTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  ModuleStaticLanguageTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Fixed_Language.getFileWriter(team, memberNo, round); 
      ModuleStaticLanguageTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleStaticLanguageTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleStaticLanguageTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticLanguageTeam2MemberWriter.writerCreated = var; 
  }
}
