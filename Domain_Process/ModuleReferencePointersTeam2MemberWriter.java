package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleReferencePointersTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleReferencePointersTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Simulation.getFileWriter(team, memberNo, round); 
      ModuleReferencePointersTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleReferencePointersTeam2MemberWriter.writerCreated == false) {
      new ModuleReferencePointersTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleReferencePointersTeam2MemberWriter.writerCreated = var; 
  }
}
