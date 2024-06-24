package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDFATeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  ModuleDFATeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_DFA.getFileWriter(team, memberNo, round);
      ModuleDFATeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleDFATeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new ModuleDFATeam1MemberWriter("t1",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleDFATeam1MemberWriter.writerCreated = var; 
  }
}
