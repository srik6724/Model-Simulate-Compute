package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleAudienceTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  ModuleAudienceTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Engagement.getFileWriter(team, memberNo, round);
      ModuleAudienceTeam2MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleAudienceTeam2MemberWriter.writerCreated == false) {
      new ModuleAudienceTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleAudienceTeam2MemberWriter.writerCreated = var; 
  }
}
