package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCombineTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  ModuleCombineTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Merge_Finalizer.getFileWriter(team, memberNo, round);
      ModuleCombineTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleCombineTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new ModuleCombineTeam2MemberWriter("t2",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleCombineTeam2MemberWriter.writerCreated = var; 
  }
}
