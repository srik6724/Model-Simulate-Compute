package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrInterpretationsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModulePrInterpretationsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_pyreason_graph.getFileWriter(team, memberNo, round);
      ModulePrInterpretationsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModulePrInterpretationsTeam1MemberWriter.writerCreated == false) {
      new ModulePrInterpretationsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModulePrInterpretationsTeam1MemberWriter.writerCreated = var; 
  }
}
