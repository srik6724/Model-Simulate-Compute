package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLoggerTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleLoggerTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Logger.getFileWriter(team, memberNo, round); 
      ModuleLoggerTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleLoggerTeam1MemberWriter.writerCreated == false) {
      new ModuleLoggerTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleLoggerTeam1MemberWriter.writerCreated = var; 
  }
}
