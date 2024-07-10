package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCompletionTimeTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleCompletionTimeTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Duration.getFileWriter(team, memberNo, round); 
      ModuleCompletionTimeTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleCompletionTimeTeam1MemberWriter.writerCreated == false) {
      new ModuleCompletionTimeTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleCompletionTimeTeam1MemberWriter.writerCreated = var; 
  }
}
