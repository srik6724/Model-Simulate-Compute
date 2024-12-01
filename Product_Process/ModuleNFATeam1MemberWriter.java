package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleNFATeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleNFATeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_NFA.getFileWriter(team, memberNo, round); 
      ModuleNFATeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleNFATeam1MemberWriter.writerCreated == false) {
      new ModuleNFATeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleNFATeam1MemberWriter.writerCreated = var; 
  }
}
