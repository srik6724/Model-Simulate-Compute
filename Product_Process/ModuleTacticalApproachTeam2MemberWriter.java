package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTacticalApproachTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleTacticalApproachTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Strategy.getFileWriter(team, memberNo, round);
      ModuleTacticalApproachTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleTacticalApproachTeam2MemberWriter.writerCreated == false) {
      new ModuleTacticalApproachTeam2MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleTacticalApproachTeam2MemberWriter.writerCreated = var; 
  }
}
