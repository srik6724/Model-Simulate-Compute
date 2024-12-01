package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleNFATeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleNFATeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_NFA.getFileWriter(team, memberNo, round); 
      ModuleNFATeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleNFATeam2MemberWriter.writerCreated == false) {
      new ModuleNFATeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleNFATeam2MemberWriter.writerCreated = var; 
  }
}
