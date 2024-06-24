package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCheckPointTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleCheckPointTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_State.getFileWriter(team, memberNo, round); 
      ModuleCheckPointTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleCheckPointTeam2MemberWriter.writerCreated == false) {
      new ModuleCheckPointTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleCheckPointTeam2MemberWriter.writerCreated = var; 
  }
}
