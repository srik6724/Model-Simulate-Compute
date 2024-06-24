package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleAudienceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  ModuleAudienceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Engagement.getFileWriter(team, memberNo, round);
      ModuleAudienceTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleAudienceTeam1MemberWriter.writerCreated == false) {
      new ModuleAudienceTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleAudienceTeam1MemberWriter.writerCreated = var; 
  }
}
