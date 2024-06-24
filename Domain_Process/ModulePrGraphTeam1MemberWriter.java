package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrGraphTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModulePrGraphTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_pyreason_graph.getFileWriter(team, memberNo, round);
      ModulePrGraphTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModulePrGraphTeam1MemberWriter.writerCreated == false) {
      new ModulePrGraphTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModulePrGraphTeam1MemberWriter.writerCreated = var; 
  }
}
