package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleModeOfOperationsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleModeOfOperationsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Hierarchy.getFileWriter(team, memberNo, round); 
      ModuleModeOfOperationsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleModeOfOperationsTeam2MemberWriter.writerCreated == false) {
      new ModuleModeOfOperationsTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleModeOfOperationsTeam2MemberWriter.writerCreated = var; 
  }
}
