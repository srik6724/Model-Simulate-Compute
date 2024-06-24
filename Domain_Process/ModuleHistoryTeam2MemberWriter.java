package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleHistoryTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleHistoryTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Documentation.getFileWriter(team, memberNo, round); 
      ModuleHistoryTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleHistoryTeam2MemberWriter.writerCreated == false) {
      new ModuleHistoryTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleHistoryTeam2MemberWriter.writerCreated = var; 
  }
}
