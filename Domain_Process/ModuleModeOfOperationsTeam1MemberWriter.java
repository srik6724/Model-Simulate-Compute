package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleModeOfOperationsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleModeOfOperationsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Hierarchy.getFileWriter(team, memberNo, round); 
      ModuleModeOfOperationsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleModeOfOperationsTeam1MemberWriter.writerCreated == false) {
      new ModuleModeOfOperationsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleModeOfOperationsTeam1MemberWriter.writerCreated = var; 
  }
}
