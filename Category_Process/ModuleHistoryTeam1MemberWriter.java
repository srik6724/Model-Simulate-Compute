package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleHistoryTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleHistoryTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Documentation.getFileWriter(team, memberNo, round); 
      ModuleHistoryTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleHistoryTeam1MemberWriter.writerCreated == false) {
      new ModuleHistoryTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleHistoryTeam1MemberWriter.writerCreated = var; 
  }
}
