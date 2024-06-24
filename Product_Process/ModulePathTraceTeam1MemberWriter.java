package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePathTraceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModulePathTraceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Transducer.getFileWriter(team, memberNo, round); 
      ModulePathTraceTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModulePathTraceTeam1MemberWriter.writerCreated == false) {
      new ModulePathTraceTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModulePathTraceTeam1MemberWriter.writerCreated = var; 
  }
}
