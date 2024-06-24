package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDFATeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  ModuleDFATeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_DFA.getFileWriter(team, memberNo, round);
      ModuleDFATeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleDFATeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new ModuleDFATeam2MemberWriter("t2",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleDFATeam2MemberWriter.writerCreated = var; 
  }
}
