package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrGraphTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModulePrGraphTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_pyreason_graph.getFileWriter(team, memberNo, round);
      ModulePrGraphTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModulePrGraphTeam2MemberWriter.writerCreated == false) {
      new ModulePrGraphTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModulePrGraphTeam2MemberWriter.writerCreated = var; 
  }
}
