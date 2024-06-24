package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleContributionalEstimateTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleContributionalEstimateTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_State.getFileWriter(team, memberNo, round); 
      ModuleContributionalEstimateTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleContributionalEstimateTeam1MemberWriter.writerCreated == false) {
      new ModuleContributionalEstimateTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleContributionalEstimateTeam1MemberWriter.writerCreated = var; 
  }
}
