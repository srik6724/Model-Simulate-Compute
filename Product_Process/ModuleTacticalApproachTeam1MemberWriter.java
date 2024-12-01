package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTacticalApproachTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleTacticalApproachTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Strategy.getFileWriter(team, memberNo, round);
      ModuleTacticalApproachTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleTacticalApproachTeam1MemberWriter.writerCreated == false) {
      new ModuleTacticalApproachTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleTacticalApproachTeam1MemberWriter.writerCreated = var; 
  }
}
