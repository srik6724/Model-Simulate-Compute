package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleContributionalEstimateTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleContributionalEstimateTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_State.getFileWriter(team, memberNo, round); 
      ModuleContributionalEstimateTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleContributionalEstimateTeam2MemberWriter.writerCreated == false) {
      new ModuleContributionalEstimateTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleContributionalEstimateTeam2MemberWriter.writerCreated = var; 
  }
}
