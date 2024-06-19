package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleReferencePointersTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleReferencePointersTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Simulation.getFileWriter(team, memberNo, round); 
      ModuleReferencePointersTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleReferencePointersTeam1MemberWriter.writerCreated == false) {
      new ModuleReferencePointersTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleReferencePointersTeam1MemberWriter.writerCreated = var; 
  }
}
