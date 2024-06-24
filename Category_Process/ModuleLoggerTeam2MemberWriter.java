package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLoggerTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleLoggerTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Logger.getFileWriter(team, memberNo, round); 
      ModuleLoggerTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleLoggerTeam2MemberWriter.writerCreated == false) {
      new ModuleLoggerTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleLoggerTeam2MemberWriter.writerCreated = var; 
  }
}
