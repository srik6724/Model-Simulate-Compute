package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrInterpretationsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModulePrInterpretationsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_pyreason_graph.getFileWriter(team, memberNo, round);
      ModulePrInterpretationsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModulePrInterpretationsTeam2MemberWriter.writerCreated == false) {
      new ModulePrInterpretationsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModulePrInterpretationsTeam2MemberWriter.writerCreated = var; 
  }
}
