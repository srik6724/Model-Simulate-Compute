package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCombineTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  ModuleCombineTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Merge_Finalizer.getFileWriter(team, memberNo, round);
      ModuleCombineTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleCombineTeam1MemberWriter.writerCreated == false) {
      new ModuleCombineTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleCombineTeam1MemberWriter.writerCreated = var; 
  }
}
