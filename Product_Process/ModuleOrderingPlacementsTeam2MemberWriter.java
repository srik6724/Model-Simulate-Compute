package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOrderingPlacementsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleOrderingPlacementsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Permutations.getFileWriter(team, memberNo, round); 
      ModuleOrderingPlacementsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleOrderingPlacementsTeam2MemberWriter.writerCreated == false) {
      new ModuleOrderingPlacementsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleOrderingPlacementsTeam2MemberWriter.writerCreated = var; 
  }
}
